package ch.grailsgroup

class Post extends SiteEntry {
	
	static belongsTo = [user:User]
	
	static hasMany = [comments:Comment, images:Image]
	
	String title
	String content
	String alias
	Boolean active = false
	
	static mapping = {
		sort dateCreated: 'desc'
	}
	
    static constraints = {
		title			nullable:false, maxSize:250
		user			nullable:false
		content			nullable:false, maxSize: 8000, widget:'wysiwyg'
		alias			nullable:false, maxSize:250
    }
}
