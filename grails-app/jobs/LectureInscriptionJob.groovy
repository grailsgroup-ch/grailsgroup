class LectureInscriptionJob {
	def groupsessionDaysService
	
	static triggers = {
		cron name: 'dailyTrigger', cronExpression: "00 00 09 * * ?" // daily Job to start at 09:00h
	  }
	
	def name = "LectureInscriptionJob"
	def group = "GrailsgroupJob"
	
	def concurrent = false
	
    def execute() {
		groupsessionDaysService.initialInvites()
		groupsessionDaysService.reminderInvites()
		groupsessionDaysService.reminderMail()
		groupsessionDaysService.tweet()
    }
}
