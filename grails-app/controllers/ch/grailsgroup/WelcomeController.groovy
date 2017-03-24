package ch.grailsgroup

class WelcomeController {
	
	def springSecurityService

    def index() {
		
		User user = springSecurityService.getCurrentUser()
		
		List posts = Post.findAllByActive(true)
		List sessions = Groupsession.findAllByGroupsessionDateLessThanEquals(new Date())
		sessions.add(Groupsession.findByGroupsessionDateGreaterThan(new Date(), [max:1, sort:'groupsessionDate', order:'asc']))

		def test = SiteEntry.list([max:1, sort:'publicationDate', order:'asc'])
		log.debug test
		
		List unsortedList = posts.plus(sessions)
		def allPosts = unsortedList.sort{a,b -> b?.publicationDate <=> a?.publicationDate}
		
		return [posts:allPosts, user:user]
    }

	def loadAjax() {



	}
}