package grailsone

import com.config.Image
import com.config.Widgets
import grails.core.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

class ListController {

    GrailsApplication grailsApplication

    @Value('${some.test.haha}')
    String haha

    @Autowired
    Widgets widgets

    @Autowired
    Image image

    @Value('${s3.region}')
    String region

    def widgets() {
        render(contentType: 'text/json') {
            ["widgets": widgets.toString()]
        }

    }

    def goodies() {
        render(contentType: 'text/json') {
            ["widgets": widgets.goodies.toString()]
        }

    }

    def haha() {
        render(contentType: 'text/json') {
            ["haha": haha]
        }

    }

    def image() {
        render(contentType: 'text/json') {
            ["images": image.toString()]
        }

    }

    def region() {
        render(contentType: 'text/json') {
            ["region": region]
        }
    }

    def all() {
        Properties properties = grailsApplication.config.toProperties()
        render(contentType: 'text/json') {
            properties
        }
    }


}
