package ch.grailsgroup

import grails.util.GrailsNameUtils

class ImageController {
		
	def grailsApplication
	def springSecurityService

	/*
	 * Schreibt das Bild in den Request. 
	 */
     def index() {
		if(!params.alias || !params.contentType){
			response.outputStream << ''
			return
		}
		try{
			Image imageDomain = Image.findByAlias(params.alias)
			if (!imageDomain?.oeffentlich && !springSecurityService.isLoggedIn()){
				params.'spring-security-redirect' = "/image/" + params.alias + "." + params.contentType
				redirect(controller:'login', params:params)
				return
			}
			byte[] image = imageDomain?.image
			if(imageDomain?.contentType?.contains("image")){
				image = ImageResizer.resize(imageDomain, 400, 400 ).toByteArray()
			}
			if(!image && !springSecurityService.isLoggedIn()){
				response.outputStream << ''
				return
			}
			response.contentType = "${imageDomain.contentType}"
			
			response.contentLength = image.length
			response.outputStream << image
		}catch(Exception e){
			response.outputStream << ''
			return
		}
	}
}
