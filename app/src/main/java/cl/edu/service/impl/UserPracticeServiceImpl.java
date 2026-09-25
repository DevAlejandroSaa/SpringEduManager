package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserPracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserPracticeRequest;
import cl.edu.dto.response.UserPracticeResponse;
import cl.edu.mapper.UserPracticeMapper;
import cl.edu.repository.UserPracticeRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.UserPracticeService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/UserPracticeService")
@RequiredArgsConstructor
@Transactional
public class UserPracticeServiceImpl extends AbstractService implements UserPracticeService {

    private final UserPracticeRepository userPracticeRepository;
    private final UserPracticeMapper userPracticeMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public UserPracticeResponse create(UserPracticeRequest userPracticeRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<UserPracticeResponse> filter(PageRequest<UserPracticeFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public UserPracticeResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserPracticeResponse update(UUID id, UserPracticeRequest userPracticeRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UserPracticeResponse patch(UUID id, UserPracticeFilterRequest userPracticeFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
