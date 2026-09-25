package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.dto.request.CourseStatusRequest;
import cl.edu.dto.response.CourseStatusResponse;
import cl.edu.entity.CourseStatus;

@Mapper(config = MapStructConfig.class)
public interface CourseStatusMapper {

    CourseStatusResponse toResponse(CourseStatus courseStatus);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    CourseStatus toEntity(CourseStatusRequest courseStatusRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    void updateEntityFromRequest(CourseStatusRequest courseStatusRequest, @MappingTarget CourseStatus courseStatus);

    CourseStatusRequest toRequest(CourseStatusFilterRequest courseStatusFilterRequest);

}
