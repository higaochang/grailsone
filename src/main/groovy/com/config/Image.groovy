package com.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix="images", ignoreUnknownFields = true)
@Component
class Image {

    Bucket whiteProviders
    Bucket providers
    Bucket products
    Bucket general

    @Override
    public String toString() {
        return "Image{" +
                "whiteProviders=" + whiteProviders +
                ", providers=" + providers +
                ", products=" + products +
                ", general=" + general +
                '}';
    }


    static class Bucket {
        String url

        @Override
        public String toString() {
            return "Bucket{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

}
