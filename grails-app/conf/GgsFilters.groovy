
class GgsFilters {

	
	def filters = {
		logger(controller:'*', action:'*') {
		
			before = {
				log.debug "Controller: ${controllerName} - Action: ${actionName} -> Params: ${params}"
			}
		}
	}
}