package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.PracticeFilterRequest;
import cl.edu.dto.request.PracticeRequest;
import cl.edu.dto.response.PracticeResponse;
import cl.edu.entity.Practice;

@Mapper(config = MapStructConfig.class)
public interface PracticeMapper {

    @Mapping(target = "academicProgramId", source = "academicProgram.id")
    @Mapping(target = "statusId", source = "status.id")
    PracticeResponse toResponse(Practice practice);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "academicProgram", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userPractices", ignore = true)
    Practice toEntity(PracticeRequest practiceRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "academicProgram", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userPractices", ignore = true)
    void updateEntityFromRequest(PracticeRequest practiceRequest, @MappingTarget Practice practice);

    PracticeRequest toRequest(PracticeFilterRequest practiceFilterRequest);

}
