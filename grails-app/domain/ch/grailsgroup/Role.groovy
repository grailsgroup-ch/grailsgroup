package ch.grailsgroup

class Role extends Master{

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority	blank: false, unique: true
	}
}
