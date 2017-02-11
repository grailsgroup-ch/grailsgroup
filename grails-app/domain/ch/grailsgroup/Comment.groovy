package ch.grailsgroup

class Comment extends Master{
	
	static belongsTo = [post:Post]
	
	static mapping = {
		content type:"text"
	}
	
	User user
	Post post
	String content
	
	Boolean approved = false
	
    static constraints = {
		user		nullable:false
		post		nullable:false
		content		nullable:false, widget:'wysiwyg'
		approved()
    }
}
