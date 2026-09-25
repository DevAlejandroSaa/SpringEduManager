package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.dto.request.PracticeStatusRequest;
import cl.edu.dto.response.PracticeStatusResponse;
import cl.edu.entity.PracticeStatus;

@Mapper(config = MapStructConfig.class)
public interface PracticeStatusMapper {

    PracticeStatusResponse toResponse(PracticeStatus entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "practices", ignore = true)
    PracticeStatus toEntity(PracticeStatusRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "practices", ignore = true)
    void updateEntityFromRequest(PracticeStatusFilterRequest request, @MappingTarget PracticeStatus entity);

}
