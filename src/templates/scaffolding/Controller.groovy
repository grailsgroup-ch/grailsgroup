<%=packageName ? "package ${packageName}\n\n" : ''%>import org.springframework.dao.DataIntegrityViolationException

class ${className}Controller {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [${propertyName}List: ${className}.list(params), ${propertyName}Total: ${className}.count()]
    }

    def create() {
        [${propertyName}: new ${className}(params)]
    }

    def save() {
        def ${propertyName} = new ${className}(params)
		
		if(!params.image?.isEmpty()  && ${propertyName}.hasProperty('image')){
			${propertyName}.contentType = request.getFile('image')?.getContentType()
		}
		
		
        if (!${propertyName}.save(flush: true)) {
            render(view: "create", model: [${propertyName}: ${propertyName}])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
        redirect(action: "list", id: ${propertyName}.id)
    }

    def show() {
        def ${propertyName} = ${className}.get(params.id)
        if (!${propertyName}) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list")
            return
        }

        [${propertyName}: ${propertyName}]
    }

    def edit() {
        def ${propertyName} = ${className}.get(params.id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list")
            return
        }

        [${propertyName}: ${propertyName}]
    }

    def update() {
        def ${propertyName} = ${className}.get(params.id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (${propertyName}.version > version) {<% def lowerCaseName = grails.util.GrailsNameUtils.getPropertyName(className) %>
                ${propertyName}.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: '${domainClass.propertyName}.label', default: '${className}')] as Object[],
                          "Another user has updated this ${className} while you were editing")
                render(view: "edit", model: [${propertyName}: ${propertyName}])
                return
            }
        }

        //Falls es ein Bild gibt: Nur überschreiben falls nicht leer
		if(${propertyName} && ${propertyName}.hasProperty('image') ){
			def oldData = ${propertyName}.image
			${propertyName}.properties = params
			if(params.image?.isEmpty()){
				${propertyName}.image = oldData
			}
			else{
				${propertyName}.contentType = request.getFile('image')?.getContentType() 
			}
		}
		else{
	        ${propertyName}.properties = params
		}

        if (!${propertyName}.save(flush: true)) {
            render(view: "edit", model: [${propertyName}: ${propertyName}])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
        redirect(action: "list", id: ${propertyName}.id)
    }

    def delete() {
        def ${propertyName} = ${className}.get(params.id)
        if (!${propertyName}) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list")
            return
        }

        try {
            ${propertyName}.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
            redirect(action: "list", id: params.id)
        }
    }
}
