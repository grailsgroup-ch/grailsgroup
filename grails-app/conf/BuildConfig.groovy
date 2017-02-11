grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.source.level = 1.7
grails.project.target.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        compile ":jquery:1.8.2"
        compile ":resources:1.1.6"
		
        compile ":cache-headers:1.1.5"
        compile ":cached-resources:1.0"
		
        build ":tomcat:$grailsVersion"
        //build ':tomcat:7.0.70'
		
		runtime ':database-migration:1.3.2'
//		runtime ":ckeditor:3.6.4.0"
		compile ":quartz:1.0-RC6"
		runtime ":spring-security-core:1.2.4"
		runtime ":twitter4j:0.3.2"
		runtime ":svn:1.0.0.M1"
    }
}
