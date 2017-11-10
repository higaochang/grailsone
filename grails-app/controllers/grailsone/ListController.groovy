package grailsone

import grails.core.GrailsApplication

class ListController {

    GrailsApplication grailsApplication


    def index() {
        render(contentType: 'text/json') {
            ["region": grailsApplication.config.getProperty('s3.region')]
        }

    }

    def region() {
        render(contentType: 'text/json') {
            ["region": grailsApplication.config.getProperty('s3.region')]
        }
    }

    def all() {
        Properties properties = grailsApplication.config.toProperties()


        render(contentType: 'text/json') {
            properties
        }
    }


}
