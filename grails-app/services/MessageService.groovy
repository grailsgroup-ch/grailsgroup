import org.springframework.context.MessageSource
import org.springframework.context.NoSuchMessageException

/**
 * MessageService should be used to get translations. 
 * Can be used from Controllers and Services
 */
class MessageService {
	def settingsService
    MessageSource messageSource
    boolean transactional = true

   /**
    * Gets translated message for given key, args and Locale
    */
    def getMessage(String key, args, Locale locale) {
    	try {
	      return messageSource.getMessage(key, args as Object[], locale)
	    } catch(NoSuchMessageException ex){
		  log.error "missing translation: $key"
		  return key
		}
    }
  
   /**
    * Gets translated message for given key, args and Locale as isoCode
    */
    def getMessage(String key, args=null, String selectedLanguage='de') {
        if(!selectedLanguage){
            selectedLanguage = 'de'
        }
        Locale locale = new Locale(selectedLanguage)
        this.getMessage(key, args, locale)
        
    }
}
