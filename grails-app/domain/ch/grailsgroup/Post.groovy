package ch.grailsgroup

class Post extends Master{
	
	static belongsTo = [user:User]
	
	static hasMany = [comments:Comment, images:Image]
	
	String title
	String content
	String alias
	Boolean active = false
	Date publicationDate
	
	static mapping = {
		sort dateCreated: 'desc'
	}
	
    static constraints = {
		title			nullable:false, maxSize:250
		user			nullable:false
		content			nullable:false, maxSize: 8000, widget:'wysiwyg'
		alias			nullable:false, maxSize:250
		publicationDate	nullable:true, display:false
    }
	
	def beforeInsert(){
		publicationDate = new Date()
	}
}
