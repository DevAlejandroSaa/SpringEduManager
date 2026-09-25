package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.PracticeEvaluationFilterRequest;
import cl.edu.dto.request.PracticeEvaluationRequest;
import cl.edu.dto.response.PracticeEvaluationResponse;
import cl.edu.entity.PracticeEvaluation;

@Mapper(config = MapStructConfig.class)
public interface PracticeEvaluationMapper {

    @Mapping(target = "userPracticeId", source = "userPractice.id")
    PracticeEvaluationResponse toResponse(PracticeEvaluation entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userPractice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PracticeEvaluation toEntity(PracticeEvaluationRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userPractice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(PracticeEvaluationFilterRequest request, @MappingTarget PracticeEvaluation entity);

}
