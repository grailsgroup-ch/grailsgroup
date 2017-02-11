package ch.grailsgroup

class GroupsessionController {
	def groupsessionDaysService
	
	def springSecurityService
	
	static scaffold = true
	
	/*
	 * Für eine Group Session anmelden
	 */
	def anmelden(){
		def groupsession = Groupsession.get(params.postId)
		def user = User.get(params.usrId)
		def anmelden = params.boolean('anmelden')
		
		Anmeldungen anmeldung = Anmeldungen.findByGroupsessionAndUser(groupsession, user)
		
		if(!anmeldung){
			anmeldung = new Anmeldungen()
			anmeldung.groupsession = groupsession
			anmeldung.user = user
		}
		anmeldung.angemeldet = anmelden
		anmeldung.save()
		redirect controller:'welcome'
		
	}
}
