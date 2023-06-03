package dev.zevolution.springdistributedjobjobrunr.bootstrap.config.jobrunr;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Optional;

/**
 * Ensure that only this MongoClient connects to primary replica set
 */
@Configuration
public class JobRunrMongoClientConfig {

    private final Logger log = LoggerFactory.getLogger(StorageProviderConfig.class);
    private final JobRunrProperties jobProperties;

    public JobRunrMongoClientConfig(JobRunrProperties jobProperties) {
        this.jobProperties = jobProperties;
    }

    @Bean
    @Order
    public Optional<MongoClient> getMongoClientInstance() {
        // The key point here is the property "readPreference=primary"
        // mongodb://localhost:27017/test?authSource=database&readPreference=primary
        // final var mongoUrl = "mongodb://admin:password@k8s:32769/jobrunr?authSource=database&readPreference=primary";
        final var mongoUrl = this.jobProperties.getMongodb();

        return Optional.ofNullable(mongoUrl)
                .map(ConnectionString::new)
                .map(this::buildSettings)
                .map(MongoClients::create);
    }

    private MongoClientSettings buildSettings(ConnectionString connectionString) {
        log.info("Getting new connection with MongoDB into primary replica set to JobRunr jobs");
        return MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();
    }

}
