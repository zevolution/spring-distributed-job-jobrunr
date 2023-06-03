package dev.zevolution.springdistributedjobjobrunr.adapter.datasources;

import dev.zevolution.springdistributedjobjobrunr.internal.repositories.CampaignsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class SomeRelationalDatabaseDataSource implements CampaignsRepository {

    private final Logger log = LoggerFactory.getLogger(SomeRelationalDatabaseDataSource.class);

    @Override
    public void sanitize() {
        try {
            log.info("Simulates workload into relational database on hostname: {} and hostAddress: {}", InetAddress.getLocalHost().getHostName(), InetAddress.getLocalHost().getHostAddress());
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
