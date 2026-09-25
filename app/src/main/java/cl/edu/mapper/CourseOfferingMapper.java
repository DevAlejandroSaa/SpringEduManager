package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.CourseOfferingFilterRequest;
import cl.edu.dto.request.CourseOfferingRequest;
import cl.edu.dto.response.CourseOfferingResponse;
import cl.edu.entity.CourseOffering;

@Mapper(config = MapStructConfig.class)
public interface CourseOfferingMapper {

    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "teacherUserId", source = "teacherUser.id")
    CourseOfferingResponse toResponse(CourseOffering entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "teacherUser", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userCourses", ignore = true)
    @Mapping(target = "courseClasses", ignore = true)
    CourseOffering toEntity(CourseOfferingRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "teacherUser", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userCourses", ignore = true)
    @Mapping(target = "courseClasses", ignore = true)
    void updateEntityFromRequest(CourseOfferingFilterRequest request, @MappingTarget CourseOffering entity);

}
