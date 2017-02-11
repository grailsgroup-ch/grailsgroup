package ch.grailsgroup

class User extends Master{
	
	static hasMany = [posts:Post]

	transient springSecurityService

	String username
	String password
	String email
	boolean enabled			= true
	boolean accountExpired	= false
	boolean accountLocked	= false
	boolean passwordExpired	= false

	static constraints = {
		username(blank: false, unique: true)
		password(blank: false, password: true, minSize: 6)
		email(blank: false, email:true)
	}

	Set<Role> getAuthorities() {
		if(this.id)
			return UserRole.findAllByUser(this).collect { it.role } as Set
		return [] as Set
	}
	
	def beforeInsert() {
		encodePassword()
	}
	
	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
	
	String toString() {
		username
	}
}
