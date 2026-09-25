package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseOfferingFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseOfferingRequest;
import cl.edu.dto.response.CourseOfferingResponse;
import cl.edu.mapper.CourseOfferingMapper;
import cl.edu.repository.CourseOfferingRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseOfferingService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseOfferingService")
@RequiredArgsConstructor
@Transactional
public class CourseOfferingServiceImpl extends AbstractService implements CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;
    private final CourseOfferingMapper courseOfferingMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseOfferingResponse create(CourseOfferingRequest courseOfferingRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<CourseOfferingResponse> filter(PageRequest<CourseOfferingFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public CourseOfferingResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CourseOfferingResponse update(UUID id, CourseOfferingRequest courseOfferingRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseOfferingResponse patch(UUID id, CourseOfferingFilterRequest courseOfferingFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
