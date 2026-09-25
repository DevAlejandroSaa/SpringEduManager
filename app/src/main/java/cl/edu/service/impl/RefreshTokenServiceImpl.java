package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.RefreshTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RefreshTokenRequest;
import cl.edu.dto.response.RefreshTokenResponse;
import cl.edu.mapper.RefreshTokenMapper;
import cl.edu.repository.RefreshTokenRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/RefreshTokenService")
@RequiredArgsConstructor
@Transactional
public class RefreshTokenServiceImpl extends AbstractService implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenMapper refreshTokenMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public RefreshTokenResponse create(RefreshTokenRequest refreshTokenRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<RefreshTokenResponse> filter(PageRequest<RefreshTokenFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public RefreshTokenResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public RefreshTokenResponse update(UUID id, RefreshTokenRequest refreshTokenRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public RefreshTokenResponse patch(UUID id, RefreshTokenFilterRequest refreshTokenFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
