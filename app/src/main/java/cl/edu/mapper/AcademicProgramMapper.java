package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.AcademicProgramFilterRequest;
import cl.edu.dto.request.AcademicProgramRequest;
import cl.edu.dto.response.AcademicProgramResponse;
import cl.edu.entity.AcademicProgram;

@Mapper(config = MapStructConfig.class)
public interface AcademicProgramMapper {

    @Mapping(target = "statusId", source = "status.id")
    AcademicProgramResponse toResponse(AcademicProgram entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "practices", ignore = true)
    AcademicProgram toEntity(AcademicProgramRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "practices", ignore = true)
    void updateEntityFromRequest(AcademicProgramFilterRequest request, @MappingTarget AcademicProgram entity);

}
