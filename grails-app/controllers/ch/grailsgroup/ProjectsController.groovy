package ch.grailsgroup

class ProjectsController {

    def index() {
		def projects = Project.list(sort:'ordering')
		[projects:projects]
	}
}
