package dev.zevolution.springdistributedjobjobrunr.internal.interactors;

import dev.zevolution.springdistributedjobjobrunr.internal.entities.Sample;
import dev.zevolution.springdistributedjobjobrunr.internal.repositories.SampleRepository;
import org.springframework.stereotype.Service;

@Service
public class SampleUseCase {

    private final SampleRepository sampleRepository;

    public SampleUseCase(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Sample execute(Integer id) {
        return sampleRepository.getSample(id);
    }

}