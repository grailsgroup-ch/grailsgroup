package ch.grailsgroup

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
    }

    def save() {
		log.debug "save " + params
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }
		
		params.role.each{
			def role = Role.findByAuthority(it)
			if(role){
				UserRole.create(userInstance, role, true)
				log.debug "asigning role: " +it
			}
		}
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "list", id: userInstance.id)
    }

    def show() {
        def userInstance = User.get(params.id)
        if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit() {
        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update() {
		log.debug "update " + params
		
        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }
		def oldPass = userInstance.password
		userInstance.properties = params       

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

		//assign roles
		UserRole.removeAll(userInstance)
		params.role.each{
			log.debug it
			def role = Role.findByAuthority(it)
			log.debug "role " +role
			if(role){
				UserRole.create(userInstance, role, true)
				log.debug "asigning role: " +it
			}
		}
		
		flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "list", id: userInstance.id)
    }

    def delete() {
        def userInstance = User.get(params.id)
        if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])
            redirect(action: "list", id: params.id)
        }
    }
}
