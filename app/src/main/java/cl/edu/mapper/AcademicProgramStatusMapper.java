package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.dto.request.AcademicProgramStatusRequest;
import cl.edu.dto.response.AcademicProgramStatusResponse;
import cl.edu.entity.AcademicProgramStatus;

@Mapper(config = MapStructConfig.class)
public interface AcademicProgramStatusMapper {

    AcademicProgramStatusResponse toResponse(AcademicProgramStatus academicProgramStatus);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "academicPrograms", ignore = true)
    AcademicProgramStatus toEntity(AcademicProgramStatusRequest academicProgramStatusRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "academicPrograms", ignore = true)
    void updateEntityFromRequest(AcademicProgramStatusRequest academicProgramStatusRequest,
            @MappingTarget AcademicProgramStatus academicProgramStatus);

    AcademicProgramStatusRequest toRequest(AcademicProgramStatusFilterRequest academicProgramStatusFilterRequest);

}
