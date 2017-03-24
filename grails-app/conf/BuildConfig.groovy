grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.source.level = 1.7
grails.project.target.level = 1.7
grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.server.port.http = 8080
grails.tomcat.nio = true
grails.tomcat.scan.enabled = true

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }

    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenRepo "https://repo.spring.io/milestone/"
        mavenRepo "https://repo.grails.org/grails/core/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'mysql:mysql-connector-java:5.1.35'
    }

    plugins {
        build ":tomcat:8.0.33"

        runtime ":hibernate4:4.3.8.1"
        compile ":jquery:1.11.1"
        compile ":resources:1.2.14"

        compile ":cache-headers:1.1.7"
        compile ":cached-resources:1.0"

        compile ":scaffolding:2.1.2"
        runtime ':database-migration:1.4.1'
        compile ":quartz:1.0.2"
        runtime ":spring-security-core:2.0.0"
        runtime ":svn:1.0.0.M1"

    }
}
