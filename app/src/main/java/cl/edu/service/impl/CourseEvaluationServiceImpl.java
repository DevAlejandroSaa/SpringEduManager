package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseEvaluationRequest;
import cl.edu.dto.response.CourseEvaluationResponse;
import cl.edu.mapper.CourseEvaluationMapper;
import cl.edu.repository.CourseEvaluationRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseEvaluationService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseEvaluationService")
@RequiredArgsConstructor
@Transactional
public class CourseEvaluationServiceImpl extends AbstractService implements CourseEvaluationService {

    private final CourseEvaluationRepository courseEvaluationRepository;
    private final CourseEvaluationMapper courseEvaluationMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseEvaluationResponse create(CourseEvaluationRequest courseEvaluationRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<CourseEvaluationResponse> filter(PageRequest<CourseEvaluationFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public CourseEvaluationResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CourseEvaluationResponse update(UUID id, CourseEvaluationRequest courseEvaluationRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseEvaluationResponse patch(UUID id, CourseEvaluationFilterRequest courseEvaluationFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
