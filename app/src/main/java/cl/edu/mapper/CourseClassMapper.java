package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.CourseClassFilterRequest;
import cl.edu.dto.request.CourseClassRequest;
import cl.edu.dto.response.CourseClassResponse;
import cl.edu.entity.CourseClass;

@Mapper(config = MapStructConfig.class)
public interface CourseClassMapper {

    @Mapping(target = "courseOfferingId", source = "courseOffering.id")
    CourseClassResponse toResponse(CourseClass courseClass);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courseOffering", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CourseClass toEntity(CourseClassRequest courseClassRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courseOffering", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(CourseClassFilterRequest courseClassFilterRequest,
            @MappingTarget CourseClass courseClass);

    CourseClassRequest toRequest(CourseClassFilterRequest courseClassFilterRequest);

}
