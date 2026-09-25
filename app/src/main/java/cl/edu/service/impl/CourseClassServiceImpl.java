package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseClassFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseClassRequest;
import cl.edu.dto.response.CourseClassResponse;
import cl.edu.mapper.CourseClassMapper;
import cl.edu.repository.CourseClassRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseClassService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseClassService")
@RequiredArgsConstructor
@Transactional
public class CourseClassServiceImpl extends AbstractService implements CourseClassService {

    private final CourseClassRepository courseClassRepository;
    private final CourseClassMapper courseClassMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseClassResponse create(CourseClassRequest courseClassRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<CourseClassResponse> filter(PageRequest<CourseClassFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public CourseClassResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CourseClassResponse update(UUID id, CourseClassRequest courseClassRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseClassResponse patch(UUID id, CourseClassFilterRequest courseClassFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
