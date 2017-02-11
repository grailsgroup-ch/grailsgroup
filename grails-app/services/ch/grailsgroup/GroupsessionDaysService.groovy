package ch.grailsgroup

import org.codehaus.groovy.grails.web.mapping.LinkGenerator

class GroupsessionDaysService {
	
	static transactional = false
	
	def settingsService
	def mailService
	def messageService
	def twitter4jService
	LinkGenerator grailsLinkGenerator
	
	private List groupsessionLists(Integer days){
		
		log.debug "Lists"
		def today = new Date().clearTime()
		def tomorrow = new Date().clearTime().plus(1)
		def groupsessions 
		Groupsession.withTransaction{
			groupsessions  = Groupsession.findAllByGroupsessionDateBetween( today.plus(days), tomorrow.plus(days) )
		}
		return groupsessions
	}
	
	
	public void initialInvites(){
		def groupsessions = groupsessionLists(settingsService.initialInviteDayLimit)
		
		User.withTransaction{
			groupsessions.each{groupsession ->
				if(groupsession.getLectures().size() < settingsService.lectureLimit){
					User.list().each{user ->
						String anmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:true], absolute:true)}">Anmelden</a>"""
						String abmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:false], absolute:true)}">Abmelden</a>"""
						def mailText = messageService.getMessage("mail.initialInvite", [groupsession.groupsessionDate.format("dd.MM.yyyy"), anmeldenLink, abmeldenLink])
						log.debug "initial Mail für: " + groupsession.toString() + groupsession.getLectures()
						
						mailService.sendMail(user.email, groupsession.toString(), mailText, true)
		
					}
				}
			}
		}
	}
	
	
	public void reminderInvites(){
		def groupsessions = groupsessionLists(settingsService.reminderInviteDayLimit)
		
		User.withTransaction{
			groupsessions.each{groupsession ->
				if(groupsession.getLectures().size() < settingsService.lectureLimit){
					User.list().each{user ->
						String anmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:true], absolute:true)}">Anmelden</a>"""
						String abmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:false], absolute:true)}">Abmelden</a>"""
							
						def mailText = messageService.getMessage("mail.reminderInvite", [groupsession.groupsessionDate.format("dd.MM.yyyy"), anmeldenLink, abmeldenLink])
						log.debug "reminder invitiation Mail für: " + groupsession.toString() + groupsession.getLectures()
						
						mailService.sendMail(user.email, groupsession.toString(), mailText, true)
					}
				}
			}
		}
	}
	
	public void reminderMail(){
		def groupsessions = groupsessionLists(settingsService.reminderMailDayLimit)
		
		User.withTransaction{
			groupsessions.each{groupsession ->
				log.debug "reminder Mail für: " + groupsession.toString() + groupsession.getLectures()
				User.list().each{user ->
					def mailLectures = ""
					if (groupsession.getLectures().size() > 0){
						mailLectures = messageService.getMessage("groupsession.lectures") + "<ul>"
						groupsession.getLectures().each{
							mailLectures += "<li>" + it.toString() + "</li>"
						}
						mailLectures += "</ul><br/><br/>"
					}
					
					String anmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:true], absolute:true)}">Anmelden</a>"""
					String abmeldenLink = """<a href="${grailsLinkGenerator.link(controller:'groupsession', action:'anmelden', params:[usrId:user.id, postId:groupsession.id, anmelden:false], absolute:true)}">Abmelden</a>"""
	
					def mailText = messageService.getMessage("mail.reminderMail", [groupsession.groupsessionDate.format("dd.MM.yyyy"), groupsession.groupsessionDate, groupsession.location, mailLectures, anmeldenLink, abmeldenLink])
					mailService.sendMail(user.email, groupsession.toString(), mailText, true)
				}
			}
		}
	}
}
