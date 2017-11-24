package com.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix="widgets", ignoreUnknownFields = true)
@Component
class Widgets {
    String version
    String layout
    String baseUrl
    String securedBaseUrl
//    Goodies goodies


    String toString() {
        return "Widgets{" +
                "version='" + version + '\'' +
                ", layout='" + layout + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", securedBaseUrl='" + securedBaseUrl + '\'' +
                '}'
    }

    static class Goodies{
        String person;
        String age;

        String getPerson() {
            return person;
        }

        void setPerson(String person) {
            this.person = person;
        }

        String getAge() {
            return age;
        }

        void setAge(String age) {
            this.age = age;
        }

        @Override
        String toString() {
            return "Goodies{" +
                    "person='" + person + '\'' +
                    ", age='" + age + '\'' +
                    '}'
        }
    }
}
