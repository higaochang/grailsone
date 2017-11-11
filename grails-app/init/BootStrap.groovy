import grails.config.Config
import grails.core.GrailsApplication
import org.springframework.cloud.config.server.environment.EnvironmentRepository
import org.yaml.snakeyaml.Yaml

class BootStrap {

    EnvironmentRepository environmentRepository

    GrailsApplication grailsApplication

    Map<String, String> mergedMap = new HashMap<>()

    Yaml yaml = new Yaml()


    def init = { servletContext ->
        List list = environmentRepository.findOne("ciab", "tw_stating", null).getPropertySources()

        for (int i = list.size()-1; i>=0; i--){
            println list.get(i).name
            list.get(i).getSource().each {k,v->
                if (v instanceof String){
                    mergedMap.put(k,v)
                }
            }
            mergedMap.putAll(list.get(i).getSource())

        }

        mergedMap.sort()

        grailsApplication.config.merge(mergedMap)



    }

    def destroy = {
    }


    void printMap(Map map){
        map.each { k, v ->
            if (v instanceof String) {
                println k
                println v
            }
        }
    }

}
