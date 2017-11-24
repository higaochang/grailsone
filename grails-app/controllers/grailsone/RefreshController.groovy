package grailsone

import grails.core.GrailsApplication
import org.springframework.cloud.config.server.environment.EnvironmentRepository

class RefreshController {



    EnvironmentRepository environmentRepository

    GrailsApplication grailsApplication

    Map<String, String> mergedMap = new HashMap<>()

    def force() {

        String[] profiles = grailsApplication.config.getProperty("spring.profiles.active").split(",")

        profiles.each { profile ->

            List yamlFileList = environmentRepository.findOne(grailsApplication.config.getProperty("spring.application.name"), profile, null).getPropertySources()

            for (int i = yamlFileList.size() - 1; i >= 0; i--) {
                println yamlFileList.get(i).name
                yamlFileList.get(i).getSource().each { k, v ->
                    if (v instanceof String) {
                        mergedMap.put(k, v)
                    }
                }
            }
            grailsApplication.config.merge(mergedMap)
            grailsApplication.configChanged()
        }


        render(contentType: 'text/json') {
            ["merged": mergedMap]
        }


    }
}
