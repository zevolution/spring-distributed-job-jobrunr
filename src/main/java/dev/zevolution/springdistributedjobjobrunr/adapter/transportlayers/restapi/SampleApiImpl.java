package dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.restapi;

import dev.zevolution.springdistributedjobjobrunr.internal.interactors.SampleUseCase;
import dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.mapper.SampleMapper;
import dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.openapi.api.SampleApi;
import dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.openapi.model.SampleResponse;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(tags = "Sample")
public class SampleApiImpl implements SampleApi {

    private final SampleUseCase sampleUseCase;

    public SampleApiImpl(SampleUseCase sampleUseCase) {
        this.sampleUseCase = sampleUseCase;
    }

    @Override
    public ResponseEntity<SampleResponse> getSample(Integer id) {
        var sample = sampleUseCase.execute(id);
        var response = SampleMapper.INSTANCE.map(sample);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}