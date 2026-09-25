package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.UserPracticeFilterRequest;
import cl.edu.dto.request.UserPracticeRequest;
import cl.edu.dto.response.UserPracticeResponse;
import cl.edu.entity.UserPractice;

@Mapper(config = MapStructConfig.class)
public interface UserPracticeMapper {

    @Mapping(target = "studentUserId", source = "studentUser.id")
    @Mapping(target = "practiceId", source = "practice.id")
    UserPracticeResponse toResponse(UserPractice userPractice);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentUser", ignore = true)
    @Mapping(target = "practice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "practiceEvaluations", ignore = true)
    UserPractice toEntity(UserPracticeRequest userPracticeRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentUser", ignore = true)
    @Mapping(target = "practice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "practiceEvaluations", ignore = true)
    void updateEntityFromRequest(UserPracticeRequest userPracticeRequest, @MappingTarget UserPractice userPractice);

    UserPracticeRequest toRequest(UserPracticeFilterRequest userPracticeFilterRequest);

}
