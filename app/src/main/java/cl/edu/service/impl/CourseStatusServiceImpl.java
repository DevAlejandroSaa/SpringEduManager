package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseStatusRequest;
import cl.edu.dto.response.CourseStatusResponse;
import cl.edu.mapper.CourseMapper;
import cl.edu.repository.CourseRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseStatusService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseStatusService")
@RequiredArgsConstructor
@Transactional
public class CourseStatusServiceImpl extends AbstractService implements CourseStatusService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseStatusResponse create(CourseStatusRequest courseStatusRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<CourseStatusResponse> filter(PageRequest<CourseStatusFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public CourseStatusResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CourseStatusResponse update(UUID id, CourseStatusRequest courseStatusRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseStatusResponse patch(UUID id, CourseStatusFilterRequest courseStatusFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
