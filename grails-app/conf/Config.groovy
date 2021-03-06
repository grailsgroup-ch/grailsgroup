// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true

// Database Migration Plugin - DB changelogs einlesen und ausführen
grails.plugin.databasemigration.updateOnStart=true
grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']

ggs.redirectMailAdress = "" //Sollen Mails an diese Adresse weitergeleitet werden? default: keine Weiterleitung

//resources plugin config
//see http://grails-plugins.github.io/grails-resources/guide/9.%20Configuration.html
grails.resources.processing.enabled = true
grails.resources.mappers.bundle.enabled = true
grails.resources.mappers.hashandcache.enabled = true
grails.resources.adhoc.patterns = ["/images/*", "*.css", "*.js"]

// set per-environment serverURL stem for creating absolute links
environments {
	development {
		grails.logging.jul.usebridge = true
		ggs.redirectMailAdress = "hostmaster@pillo-srv." //keine Mails in dev env versenden
		quartz {
			autoStartup = false
		}
	}
	test {
		grails.logging.jul.usebridge = false
		grails.serverURL = "https://grailsgroup.pillo-srv.ch"
		ggs.redirectMailAdress = "hostmaster@pillo-srv.ch" //keine Mails in dev env versenden
		quartz {
			autoStartup = false
		}
	}
	production {
		grails.logging.jul.usebridge = false
		grails.serverURL = "https://grailsgroup.ch"
	}
}

//******************************************************
//     Log4j Configuration
//    dev: debug to console
//    test: debug to file
//    prod: info to file
//    Logging hints see: http://stackoverflow.com/questions/6724531/grails-log4j-not-logging-in-production
//
//******************************************************
environments {
	development {
		log4j = {

			debug 'grails.app.jobs',                                // Jobs
					'grails.app.domain',                             // Domain Logs
					'grails.app.controllers',                         // Controller Logs
					'grails.app.services',                              // Services Logs
					'grails.app.conf',
					'grails.plugins.twitterbootstrap.BootstrapResources'
			warn 'org.springframework',
					'org.hibernate',
					'net.sf.ehcache.hibernate'
			error 'org.codehaus.groovy.grails.web.servlet',
					'org.codehaus.groovy.grails.web.pages',          // GSP
					'org.codehaus.groovy.grails.web.sitemesh',       // layouts
					'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
					'org.codehaus.groovy.grails.web.mapping',        // URL mapping
					'org.codehaus.groovy.grails.commons',            // core / classloading
					'org.codehaus.groovy.grails.plugins',            // plugins
					'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
					'dalew.CookieService',
					'grails.app.services.com.dalew.CookieService',
					'net.sf.ehcache.hibernate.AbstractEhcacheRegionFactory'
		}
	}

	test {
		log4j = {
			debug 'grails.app.jobs',                                // Jobs
					'grails.app.domain',                             // Domain Logs
					'grails.app.controllers',                         // Controller Logs
					'grails.app.services',                              // Services Logs
					'grails.app.conf'
			warn 'org.springframework',
					'org.hibernate',
					'net.sf.ehcache.hibernate'
			error 'org.codehaus.groovy.grails.web.servlet',
					'org.codehaus.groovy.grails.web.pages',          // GSP
					'org.codehaus.groovy.grails.web.sitemesh',       // layouts
					'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
					'org.codehaus.groovy.grails.web.mapping',        // URL mapping
					'org.codehaus.groovy.grails.commons',            // core / classloading
					'org.codehaus.groovy.grails.plugins',            // plugins
					'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
					'dalew.CookieService',
					'grails.app.services.com.dalew.CookieService',
					'net.sf.ehcache.hibernate.AbstractEhcacheRegionFactory'
		}
	}

	production {
		log4j = {
			info 'grails.app.jobs',                                // Jobs
					'grails.app.domain',                             // Domain Logs
					'grails.app.controllers',                         // Controller Logs
					'grails.app.services',                             // Services Logs
					'grails.app.conf'
			error 'org.springframework',
					'org.hibernate',
					'net.sf.ehcache.hibernate',
					'org.codehaus.groovy.grails.web.servlet',
					'grails.app.services.com.dalew.CookieService',
					'org.codehaus.groovy.grails.web.pages',          // GSP
					'org.codehaus.groovy.grails.web.sitemesh',       // layouts
					'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
					'org.codehaus.groovy.grails.web.mapping',        // URL mapping
					'org.codehaus.groovy.grails.commons',            // core / classloading
					'org.codehaus.groovy.grails.plugins',            // plugins
					'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
					'dalew.CookieService',
					'net.sf.ehcache.hibernate.AbstractEhcacheRegionFactory'
		}
	}
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'ch.grailsgroup.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'ch.grailsgroup.UserRole'
grails.plugin.springsecurity.authority.className = 'ch.grailsgroup.Role'
grails.plugin.springsecurity.requestMap.className = 'ch.grailsgroup.Requestmap'
grails.plugin.springsecurity.securityConfigType = 'Requestmap'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/dashboard'

// Supporting Old Passwords from Spring Security 1.x
grails.plugin.springsecurity.password.algorithm = 'SHA-256'
grails.plugin.springsecurity.password.hash.iterations = 1
