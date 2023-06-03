package dev.zevolution.springdistributedjobjobrunr.bootstrap.config;

import dev.zevolution.springdistributedjobjobrunr.bootstrap.config.jobrunr.JobRunrProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ JobRunrProperties.class})
public class PropertiesConfig {

}
