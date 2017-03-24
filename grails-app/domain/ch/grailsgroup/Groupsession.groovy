package ch.grailsgroup

class Groupsession extends SiteEntry {
	
	Date groupsessionDate
	String location
	String locationGoogleUrl
	String remark
	
	static constraints = {
		groupsessionDate	nullable:false
		location			nullable:false, maxSize:250
		locationGoogleUrl	nullable:true, maxSize:500
		remark				nullable:false, maxSize:8000, widget:'wysiwyg'
	}
	
	List getLectures(){
		return Lectures.findAllByGroupsession(this)
	}
	
	String toString(){
		return "Group Session " + groupsessionDate.format("dd.MM.yyyy")
	}
	
	/*
	 * Liste mit Personen:
	 * - Falls angemeldet = false: abgemeldetet Personen, ansonsten die angemeldeten
	 */
	List getAnmeldungen(def angemeldet = true){
		return Anmeldungen.findAllByGroupsessionAndAngemeldet(this, angemeldet)*.user
	}
}
