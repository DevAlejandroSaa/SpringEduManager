package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserCourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserCourseRequest;
import cl.edu.dto.response.UserCourseResponse;
import cl.edu.mapper.UserCourseMapper;
import cl.edu.repository.UserCourseRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.UserCourseService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/UserCourseService")
@RequiredArgsConstructor
@Transactional
public class UserCourseServiceImpl extends AbstractService implements UserCourseService {

    private final UserCourseRepository userCourseRepository;
    private final UserCourseMapper userCourseMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public UserCourseResponse create(UserCourseRequest userCourseRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<UserCourseResponse> filter(PageRequest<UserCourseFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public UserCourseResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserCourseResponse update(UUID id, UserCourseRequest userCourseRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UserCourseResponse patch(UUID id, UserCourseFilterRequest userCourseFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
