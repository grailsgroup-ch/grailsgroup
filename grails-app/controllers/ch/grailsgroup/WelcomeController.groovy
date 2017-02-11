package ch.grailsgroup

class WelcomeController {
	
	def springSecurityService

    def index() {
		
		User user = springSecurityService.getCurrentUser()
		
		List posts = Post.findAllByActive(true)
		List sessions = Groupsession.findAllByGroupsessionDateLessThanEquals(new Date())
		sessions.add(Groupsession.findByGroupsessionDateGreaterThan(new Date(), [max:1, sort:'groupsessionDate', order:'asc']))
		
		
		List unsortedList = posts.plus(sessions)
		def allPosts = unsortedList.sort{a,b -> b?.publicationDate <=> a?.publicationDate}
		
		return [posts:allPosts, user:user]
    }
}