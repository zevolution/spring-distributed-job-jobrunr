package dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.mapper;

import dev.zevolution.springdistributedjobjobrunr.internal.entities.Sample;
import dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.openapi.model.SampleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SampleMapper {

    SampleMapper INSTANCE = Mappers.getMapper(SampleMapper.class);

    SampleResponse map(Sample sample);

}

