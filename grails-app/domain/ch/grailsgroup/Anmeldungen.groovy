package ch.grailsgroup

class Anmeldungen extends Master{
	
	User user
	Groupsession groupsession
	
	Boolean angemeldet = false

    static constraints = {
		user(nullable:false)
		groupsession(nullable:false)
    }
}
