import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

import org.springframework.beans.factory.InitializingBean
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import grails.util.GrailsUtil

class MailService implements InitializingBean{
	
	boolean transactional = false
	def settingsService
	def grailsApplication
	JavaMailSenderImpl mailSender
	SimpleMailMessage mailMessage// a "prototype" email instance
	String mailTemplate

	void afterPropertiesSet() {
		mailSender = new JavaMailSenderImpl()
		mailMessage = new SimpleMailMessage()
		
		// load the mail template
		File mailTemplateFile = grailsApplication.parentContext.getResource("mail/MailTemplate.html").file
		mailTemplate = mailTemplateFile.getText()
	}

	void initMail() {
		mailSender.setHost(settingsService.ggsMailSenderHost)
		mailMessage.setFrom(settingsService.ggsMailSenderFrom)
	}

	public sendMail(to, subject, text, html=false, file=null, fileName=null){
		sendMails([[to:to, subject:subject, text:text, file:file, fileName:fileName, html:html]])
	}

	def sendMails(mails) {
		initMail()
		def messages = []
		for (mail in mails) {
			// Create a thread safe "sandbox" of the message
			MimeMessage myMessage = mailSender.createMimeMessage()
			
			MimeMessageHelper message = new MimeMessageHelper(myMessage, true);
			message.setFrom(mailMessage.getFrom())
			
	if(grailsApplication.config.ggs.redirectMailAdress?.contains('@')) {
				def redirectEmails = grailsApplication.config.ggs.redirectMailAdress.split(',')?.toList()
				// to braucht eine Liste. Diese wird im Config.groovy definiert mit []
				if (redirectEmails.size() > 1) {
					for (addr in redirectEmails) {
						message.addTo(new InternetAddress(addr))
					}
				} else {
					message.setTo(new InternetAddress(redirectEmails.first()))
				}
		
				mail.text = "This mail was supposed to go to ${mail.to} but was redirected to you: "+ (mail.html?"<br><br>":'\n\n') + mail.text
			} else {
				if (mail.to instanceof List) {
					for (addr in mail.to) {
						message.addTo(new InternetAddress(addr))
					}
				} else {
					message.setTo(new InternetAddress(mail.to))
				}
				message.setText(mail.text, mail.html)
			}
			message.setSubject(mail.subject)
						
			// Haben wir ein Attachment? Dann müssen wir es anhängen
			if (mail.file) {
				message.addAttachment(mail.fileName, mail.file)
			}
			
			if (mail.html){
				// replace the mail template's body with the current mail text
				def text = mailTemplate
				text = text.replace("%%%BODY%%%", mail.text)
				mail.text = text
			}
			
			message.setText(mail.text, mail.html)
			
			if (mail.html) {
				// add the inline logo required in the mail template
				File baseImagesFolder = grailsApplication.parentContext.getResource("images").file
				File headerLogo = new File(baseImagesFolder, "logo.png")
				message.addInline("header-logo", new FileSystemResource(headerLogo))
			}
			
			log.debug "------------------- Dieses Mail geht an: " + myMessage.allRecipients + ', sollte aber an: ' + mail.to
			messages << myMessage
		}
		
		// Send them all together
		try {
			mailSender.send(messages as MimeMessage[])
		} catch (MailException ex) {
			log.error "Failed to send emails " + ex
		}
	}
}