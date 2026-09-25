package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.UserCourseFilterRequest;
import cl.edu.dto.request.UserCourseRequest;
import cl.edu.dto.response.UserCourseResponse;
import cl.edu.entity.UserCourse;

@Mapper(config = MapStructConfig.class)
public interface UserCourseMapper {

    @Mapping(target = "studentUserId", source = "studentUser.id")
    @Mapping(target = "courseOfferingId", source = "courseOffering.id")
    UserCourseResponse toResponse(UserCourse entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentUser", ignore = true)
    @Mapping(target = "courseOffering", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courseEvaluations", ignore = true)
    UserCourse toEntity(UserCourseRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentUser", ignore = true)
    @Mapping(target = "courseOffering", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "courseEvaluations", ignore = true)
    void updateEntityFromRequest(UserCourseFilterRequest request, @MappingTarget UserCourse entity);

}
