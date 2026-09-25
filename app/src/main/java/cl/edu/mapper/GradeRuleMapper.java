package cl.edu.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import cl.edu.core.mapStruct.MapStructConfig;
import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.dto.request.GradeRuleRequest;
import cl.edu.dto.response.GradeRuleResponse;
import cl.edu.entity.GradeRule;

@Mapper(config = MapStructConfig.class)
public interface GradeRuleMapper {

    GradeRuleResponse toResponse(GradeRule gradeRule);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GradeRule toEntity(GradeRuleRequest gradeRuleRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(GradeRuleRequest gradeRuleRequest, @MappingTarget GradeRule gradeRule);

    GradeRuleRequest toRequest(GradeRuleFilterRequest gradeRuleFilterRequest);

}
