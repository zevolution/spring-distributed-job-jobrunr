package dev.zevolution.springdistributedjobjobrunr.internal.interactors;

import dev.zevolution.springdistributedjobjobrunr.internal.repositories.CampaignsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CampaignsSanitizeUseCase {

    private final Logger log = LoggerFactory.getLogger(CampaignsSanitizeUseCase.class);
    private final CampaignsRepository campaignsRepository;

    public CampaignsSanitizeUseCase(CampaignsRepository campaignsRepository) {
        this.campaignsRepository = campaignsRepository;
    }

    public void execute() {
        log.info("Simulate workload to sanitize Campaigns");

        this.campaignsRepository.sanitize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
