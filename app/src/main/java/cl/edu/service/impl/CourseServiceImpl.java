package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseRequest;
import cl.edu.dto.response.CourseResponse;
import cl.edu.mapper.CourseMapper;
import cl.edu.repository.CourseRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseService")
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl extends AbstractService implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseResponse create(CourseRequest courseRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<CourseResponse> filter(PageRequest<CourseFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public CourseResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CourseResponse update(UUID id, CourseRequest courseRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseResponse patch(UUID id, CourseFilterRequest courseFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
