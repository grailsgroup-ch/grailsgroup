package ch.grailsgroup

class GgsTagLib {
	
	static namespace = "ggs"
	
	/**
	* Rendert das Bild einer Domain
	* Erstellt URL wie "/image/alias.png"
	* use: <ggs:img image="${myDomain.image}" alt="hug was here?"/>
	* @see ImageController
	*/
	def img = { attrs, body ->
		
		def image = attrs['image']
		if(!image || !image.image){
			return
		}
		
		def contentType = image.contentType - 'image/'
		//create url like "/image/alias.png"
		//attrs durchreichen
		def excludes = ['image']
		def entries = attrs.findAll { !(it.key in excludes) }.collect { "$it.key=\"$it.value\""}
		out << render(template:'/tags/image', model:[entries:entries, image:image, contentType:contentType])
	}
}
