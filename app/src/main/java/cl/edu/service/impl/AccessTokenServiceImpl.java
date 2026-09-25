package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessTokenRequest;
import cl.edu.dto.response.AccessTokenResponse;
import cl.edu.mapper.AccessTokenMapper;
import cl.edu.repository.AccessTokenRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.AccessTokenService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/AccessToken")
@RequiredArgsConstructor
@Transactional
public class AccessTokenServiceImpl extends AbstractService implements AccessTokenService {

    private final AccessTokenRepository accessTokenRepository;
    private final AccessTokenMapper accessTokenMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public AccessTokenResponse create(AccessTokenRequest accessTokenRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<AccessTokenResponse> filter(PageRequest<AccessTokenFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public AccessTokenResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public AccessTokenResponse update(UUID id, AccessTokenRequest accessTokenRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public AccessTokenResponse patch(UUID id, AccessTokenFilterRequest accessTokenFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
