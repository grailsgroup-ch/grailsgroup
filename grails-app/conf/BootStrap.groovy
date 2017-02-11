import ch.grailsgroup.*

class BootStrap {
	def settingsService
    def init = { servletContext ->

		//Rollen erstellen
		Role adminRole = Role.findOrSaveByAuthority('ROLE_ADMIN')
		Role bloggerRole = Role.findOrSaveByAuthority('ROLE_BLOGGER')

		//RequestMaps
		Requestmap.findOrSaveByUrlAndConfigAttribute('/**', 'IS_AUTHENTICATED_ANONYMOUSLY')
		Requestmap.findOrSaveByUrlAndConfigAttribute('/comment/**', 'ROLE_ADMIN,ROLE_BLOGGER')
		Requestmap.findOrSaveByUrlAndConfigAttribute('/post/**', 'ROLE_ADMIN,ROLE_BLOGGER')
		Requestmap.findOrSaveByUrlAndConfigAttribute('/user/**', 'ROLE_ADMIN')
		Requestmap.findOrSaveByUrlAndConfigAttribute('/project/**', 'ROLE_ADMIN,ROLE_BLOGGER')
		
		//Admin boostrappen
		User admin = User.findByEmail('admin@grailsgroup.ch')
		if(!admin){
			admin = new User(
						email:'admin@grailsgroup.ch',
						username:'Admin', 
						password: '4867c3121d6651b650e263c0ceef44a7de8107dd8aad08226b54454f2498e497'
						).save()
						
			UserRole.create(admin, adminRole)
			UserRole.create(admin, bloggerRole)
		}
		
		settingsService.configInit()
    }
    def destroy = {
    }
}
