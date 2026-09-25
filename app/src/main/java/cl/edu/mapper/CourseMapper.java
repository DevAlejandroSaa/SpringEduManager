package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.CourseFilterRequest;
import cl.edu.dto.request.CourseRequest;
import cl.edu.dto.response.CourseResponse;
import cl.edu.entity.Course;

@Mapper(config = MapStructConfig.class)
public interface CourseMapper {

    @Mapping(target = "academicProgramId", source = "academicProgram.id")
    @Mapping(target = "statusId", source = "status.id")
    CourseResponse toResponse(Course course);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "academicProgram", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courseOfferings", ignore = true)
    Course toEntity(CourseRequest courseRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "academicProgram", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courseOfferings", ignore = true)
    void updateEntityFromRequest(CourseRequest courseRequest, @MappingTarget Course course);

    CourseRequest toRequest(CourseFilterRequest courseFilterRequest);

}
