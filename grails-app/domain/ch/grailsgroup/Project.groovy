package ch.grailsgroup

class Project {
	
	String name
	String alias
	String description
	Image image
	
	String linkURL
	String linkText
	String linkTitle
	
	Integer ordering = 100
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
		name 			nullable:false
		alias			nullable:false, blank:false, 	unique:true
		description		nullable:false, maxSize:2000
		image			nullable:true
		
		ordering		nullable:true
		
		linkURL			nullable:true
		linkText		nullable:true
		linkTitle		nullable:true
		
		dateCreated		nullable:true, 	display:false 
		lastUpdated		nullable:true, 	display:false 
    }
}
