import grails.core.GrailsApplication
import org.springframework.cloud.config.server.environment.EnvironmentRepository

class BootStrap {

    EnvironmentRepository environmentRepository

    GrailsApplication grailsApplication

    def init = { servletContext ->
        List list = environmentRepository.findOne("ciab", "tw", null).getPropertySources()

        for (int i = list.size()-1; i>=0; i--){
            println list.get(i).name
            list.get(i).getSource().each {k,v ->
                if (v instanceof String){
                    println k
                    println v
                }

            }
            grailsApplication.config.merge(list.get(i).getSource())
        }
    }

    def destroy = {
    }


}
