class JobFireController {
	def quartzScheduler
	
    def index = {
		quartzScheduler.start()
		quartzScheduler.triggerJob('LectureInscriptionJob', 'GrailsgroupJob')
		redirect(controller:'welcome')
	}
}
