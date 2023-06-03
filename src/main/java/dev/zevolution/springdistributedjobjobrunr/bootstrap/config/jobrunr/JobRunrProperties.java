package dev.zevolution.springdistributedjobjobrunr.bootstrap.config.jobrunr;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "jobrunr")
@Validated
public class JobRunrProperties {

    private String mongodb;

    public String getMongodb() {
        return mongodb;
    }

    public JobRunrProperties setMongodb(String mongodb) {
        this.mongodb = mongodb;
        return this;
    }

}
