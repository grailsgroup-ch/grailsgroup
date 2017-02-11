package ch.grailsgroup

class Lectures extends Master{
	
	String topic
	Image document
	User presenter
	Groupsession groupsession
	String summary
	
	static constraints = {
		topic			nullable:false
		document		nullable:true
		presenter		nullable:false
		groupsession	nullable:true
		summary			nullable:false, blank:false, size:1..255
	}
	
	String toString(){
		return topic +" (" +  presenter.toString() + ")"
	}
	
	def afterInsert() {
		this.groupsession.publicationDate = new Date()
		this.groupsession.save()
	}
	
	def afterUpdate() {
		this.groupsession.publicationDate = new Date()
		this.groupsession.save()
	}
}
