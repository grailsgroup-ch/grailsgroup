package ch.grailsgroup

class SettingsService {

	Integer initialInviteDayLimit
	Integer reminderInviteDayLimit
	Integer reminderMailDayLimit
	Integer tweetingDayLimit
	Integer lectureLimit
	String ggsMailSenderHost
	String ggsMailSenderFrom
	
	public configInit(){
		
		initialInviteDayLimit = (Settings.findByCode("initialInviteDayLimit")?:createMissing("initialInviteDayLimit", "35", "Daylimit to send the initial invite Mail for a Groupsession"))?.toInteger()
		reminderInviteDayLimit = (Settings.findByCode("reminderInviteDayLimit")?:createMissing("reminderInviteDayLimit", "10", "Daylimit to send a reminder invitation Mail for a Groupsession"))?.toInteger()
		reminderMailDayLimit = (Settings.findByCode("reminderMailDayLimit")?:createMissing("reminderMailDayLimit", "2", "Daylimit to send a reminder Mail for a Groupsession"))?.toInteger()
		tweetingDayLimit = (Settings.findByCode("tweetingDayLimit")?:createMissing("tweetingDayLimit", "1", "Daylimit to tweet the data of a Groupsession"))?.toInteger()
		lectureLimit = (Settings.findByCode("lectureLimit")?:createMissing("lectureLimit", "2", "Limit of Lectures per Groupsession to send an invitation Mail"))?.toInteger()
		ggsMailSenderHost = (Settings.findByCode("ggsMailSenderHost")?:createMissing("ggsMailSenderHost", "localhost", "smtp Host to send emails"))?.value
		ggsMailSenderFrom = (Settings.findByCode("ggsMailSenderFrom")?:createMissing("ggsMailSenderFrom", "dev@openconcept.ch", "Email account to send emails"))?.value
	}
	private Settings createMissing(String code, String value, String description){
		log.debug " creating new for $code $value"
		Settings setting = new Settings(code:code, value:value, description:description)
		setting.validate()
		setting.errors.allErrors.each{
			log.debug it
		}
		log.debug " saving new for $code $value"
		log.debug "code exists? $code" + Settings.findByCode(code)
		setting.save(flush:true)
		log.debug "code exists after? $code" + Settings.findByCode(code)
		return setting
	}
	
}
