package grailsone

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.ComponentScan

@ComponentScan("com.config")
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

}