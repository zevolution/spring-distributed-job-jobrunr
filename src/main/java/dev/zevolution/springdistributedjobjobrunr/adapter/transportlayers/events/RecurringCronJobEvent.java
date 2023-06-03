package dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.events;

import dev.zevolution.springdistributedjobjobrunr.internal.interactors.CampaignsSanitizeUseCase;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Component;

@Component
public class RecurringCronJobEvent {

    private final CampaignsSanitizeUseCase campaignsSanitizeUseCase;

    public RecurringCronJobEvent(CampaignsSanitizeUseCase campaignsSanitizeUseCase) {
        this.campaignsSanitizeUseCase = campaignsSanitizeUseCase;
    }

    @Recurring(id = "campaings-sanitize-job", cron = "${campaigns.sanitize.periods.cron}")
    @Job(name = "Campaings Sanitize Job")
    public void campaignsSanitize() {
        this.campaignsSanitizeUseCase.execute();
    }

}
