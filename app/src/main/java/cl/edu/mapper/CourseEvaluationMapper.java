package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.CourseEvaluationFilterRequest;
import cl.edu.dto.request.CourseEvaluationRequest;
import cl.edu.dto.response.CourseEvaluationResponse;
import cl.edu.entity.CourseEvaluation;

@Mapper(config = MapStructConfig.class)
public interface CourseEvaluationMapper {

    @Mapping(target = "userCourseId", source = "userCourse.id")
    CourseEvaluationResponse toResponse(CourseEvaluation courseEvaluation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userCourse", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CourseEvaluation toEntity(CourseEvaluationRequest courseEvaluationRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userCourse", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(CourseEvaluationRequest courseEvaluationRequest,
            @MappingTarget CourseEvaluation courseEvaluation);

    CourseEvaluationRequest toRequest(CourseEvaluationFilterRequest courseEvaluationFilterRequest);

}
