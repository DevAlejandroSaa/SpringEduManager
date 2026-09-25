package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.GradeRuleRequest;
import cl.edu.dto.response.GradeRuleResponse;
import cl.edu.mapper.GradeRuleMapper;
import cl.edu.repository.GradeRuleRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.GradeRuleService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/GradeRule")
@RequiredArgsConstructor
@Transactional
public class GradeRuleServiceImpl extends AbstractService implements GradeRuleService {

    private final GradeRuleRepository gradeRuleRepository;
    private final GradeRuleMapper gradeRuleMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public GradeRuleResponse create(GradeRuleRequest gradeRuleRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<GradeRuleResponse> filter(PageRequest<GradeRuleFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public GradeRuleResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public GradeRuleResponse update(UUID id, GradeRuleRequest gradeRuleRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public GradeRuleResponse patch(UUID id, GradeRuleFilterRequest gradeRuleFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
