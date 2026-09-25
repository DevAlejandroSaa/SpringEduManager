package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.AcademicProgramStatusDto;
import cl.edu.entity.AcademicProgramStatus;

@Mapper(config = MapStructConfig.class)
public interface AcademicProgramStatusMapper {

    // AcademicProgramStatusDto toDto(AcademicProgramStatus entity);

    // @Mapping(target = "createdAt", ignore = true)
    // @Mapping(target = "updatedAt", ignore = true)
    // AcademicProgramStatus toEntity(AcademicProgramStatusDto dto);

    // @BeanMapping(nullValuePropertyMappingStrategy =
    // NullValuePropertyMappingStrategy.IGNORE)
    // @Mapping(target = "id", ignore = true)
    // @Mapping(target = "createdAt", ignore = true)
    // @Mapping(target = "updatedAt", ignore = true)
    // void updateEntityFromDto(AcademicProgramStatusDto dto, @MappingTarget
    // AcademicProgramStatus entity);

}
