package dev.zevolution.springdistributedjobjobrunr.bootstrap.config.jobrunr;

import com.mongodb.client.MongoClient;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.nosql.mongo.MongoDBStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageProviderConfig {

    private final JobRunrMongoClientConfig jobRunrMongoClientConfig;

    public StorageProviderConfig(JobRunrMongoClientConfig jobRunrMongoClientConfig) {
        this.jobRunrMongoClientConfig = jobRunrMongoClientConfig;
    }

    @Bean
    public StorageProvider storageProvider(JobMapper jobMapper, MongoClient defaultMongoClient) {
        var mongoClient = this.jobRunrMongoClientConfig.getMongoClientInstance().orElse(defaultMongoClient);
        var storageProvider = new MongoDBStorageProvider(mongoClient);
        storageProvider.setJobMapper(jobMapper);
        return storageProvider;
    }

}
