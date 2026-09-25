package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeEvaluationRequest;
import cl.edu.dto.response.PracticeEvaluationResponse;
import cl.edu.mapper.PracticeEvaluationMapper;
import cl.edu.repository.PracticeEvaluationRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.PracticeEvaluationService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/PracticeEvaluationService")
@RequiredArgsConstructor
@Transactional
public class PracticeEvaluationServiceImpl extends AbstractService implements PracticeEvaluationService {

    private final PracticeEvaluationRepository practiceEvaluationRepository;
    private final PracticeEvaluationMapper practiceEvaluationMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public PracticeEvaluationResponse create(PracticeEvaluationRequest practiceEvaluationRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<PracticeEvaluationResponse> filter(PageRequest<PracticeEvaluationFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public PracticeEvaluationResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public PracticeEvaluationResponse update(UUID id, PracticeEvaluationRequest practiceEvaluationRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public PracticeEvaluationResponse patch(UUID id, PracticeEvaluationFilterRequest practiceEvaluationFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
