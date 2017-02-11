package ch.grailsgroup


class Settings extends Master{
	def settingsService
	
	String code
	String value
	String description
	
	static constraints = {
		code(nullable: false, blank:false, maxSize:250, unique:true)
		value(nullable: false, blank:false, maxSize:250)
		description(nullable: false, blank:false, size:1..255)
	}

	String toString() {
		return value
	}
	Integer toInteger() {
		return value.toInteger()
	}
	Boolean toBoolean(){
		return value.toBoolean()
	}
	
	/**
	 * Nach dem Aktualisieren der Settings müssen
	 * die Konstanten neu eingelesen werden.
	 */
	def afterUpdate(){
		log.debug "afterUpdate settings  $code $value $id"
		Settings.withNewSession{ settingsService.configInit() }
	}

	/**
	 * Nach dem Erstellen der Settings müssen
	 * die Konstanten neu eingelesen werden.
	 */
	def afterInsert(){
		log.debug "afterInsert settings $code $value $id"
		Settings.withNewSession{ settingsService.configInit() }
	}
}
