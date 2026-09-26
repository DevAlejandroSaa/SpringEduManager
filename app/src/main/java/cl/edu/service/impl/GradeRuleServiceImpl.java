package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.GradeRuleSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.GradeRuleRequest;
import cl.edu.dto.response.GradeRuleResponse;
import cl.edu.entity.GradeRule;
import cl.edu.mapper.GradeRuleMapper;
import cl.edu.repository.GradeRuleRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.GradeRuleService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/GradeRuleService")
@RequiredArgsConstructor
@Transactional
public class GradeRuleServiceImpl extends AbstractService implements GradeRuleService {

    private final GradeRuleRepository gradeRuleRepository;
    private final GradeRuleMapper gradeRuleMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public GradeRuleResponse create(GradeRuleRequest gradeRuleRequest) {
        if (this.gradeRuleRepository.existsByGrade(gradeRuleRequest.grade())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.grade_rule.grade_exists"));
        }

        GradeRule gradeRule = this.gradeRuleMapper.toEntity(gradeRuleRequest);

        return this.gradeRuleMapper.toResponse(this.gradeRuleRepository.save(gradeRule));
    }

    @Override
    public PageResponse<GradeRuleResponse> filter(PageRequest<GradeRuleFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                GradeRule.class,
                pageRequest,
                GradeRuleSpecification::apply,
                this.gradeRuleMapper::toResponse);
    }

    @Override
    public GradeRuleResponse getById(UUID id) {
        GradeRule gradeRule = findEntityById(
                this.gradeRuleRepository,
                id,
                this.i18nConfig.getMessage("error.grade_rule.not_found"));

        return this.gradeRuleMapper.toResponse(gradeRule);
    }

    @Override
    public GradeRuleResponse update(UUID id, GradeRuleRequest gradeRuleRequest) {
        GradeRule gradeRule = findEntityById(
                this.gradeRuleRepository,
                id,
                this.i18nConfig.getMessage("error.grade_rule.not_found"));
        
        if (this.gradeRuleRepository.existsByGradeAndIdNot(gradeRuleRequest.grade(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.grade_rule.grade_exists"));
        }

        this.gradeRuleMapper.updateEntityFromRequest(gradeRuleRequest, gradeRule);

        return this.gradeRuleMapper.toResponse(this.gradeRuleRepository.save(gradeRule));
    }

    @Override
    public GradeRuleResponse patch(UUID id, GradeRuleFilterRequest gradeRuleFilterRequest) {
        GradeRule gradeRule = findEntityById(
                this.gradeRuleRepository,
                id,
                this.i18nConfig.getMessage("error.grade_rule.not_found"));

        GradeRuleRequest gradeRuleRequest = this.gradeRuleMapper.toRequest(gradeRuleFilterRequest);

        this.gradeRuleMapper.updateEntityFromRequest(gradeRuleRequest, gradeRule);

        return this.gradeRuleMapper.toResponse(this.gradeRuleRepository.save(gradeRule));
    }

    @Override
    public DeleteDto delete(UUID id) {
        GradeRule gradeRule = findEntityById(
                this.gradeRuleRepository,
                id,
                this.i18nConfig.getMessage("error.grade_rule.not_found"));

        this.gradeRuleRepository.delete(gradeRule);
        
        return new DeleteDto(this.i18nConfig.getMessage("success.grade_rule.deleted"));
    }

}
