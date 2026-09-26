package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.AccessSpecification;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessRequest;
import cl.edu.dto.response.AccessResponse;
import cl.edu.entity.Access;
import cl.edu.mapper.AccessMapper;
import cl.edu.repository.AccessRepository;
import cl.edu.repository.AccessStatusRepository;
import cl.edu.repository.RoleRepository;
import cl.edu.repository.UserInformationRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.AccessService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/AccessService")
@RequiredArgsConstructor
@Transactional
public class AccessServiceImpl extends AbstractService implements AccessService {

    private final AccessRepository accessRepository;
    private final AccessMapper accessMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    private final RoleRepository roleRepository;
    private final UserInformationRepository userInformationRepository;
    private final AccessStatusRepository accessStatusRepository;

    @Override
    public AccessResponse create(AccessRequest accessRequest) {
        return null;
    }

    @Override
    public PageResponse<AccessResponse> filter(PageRequest<AccessFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                Access.class,
                pageRequest,
                AccessSpecification::apply,
                accessMapper::toResponse);
    }

    @Override
    public AccessResponse getById(UUID id) {
        Access access = findEntityById(
                accessRepository,
                id,
                i18nConfig.getMessage("error.access.not_found"));

        return accessMapper.toResponse(access);
    }

    @Override
    public AccessResponse update(UUID id, AccessRequest accessRequest) {
        return null;
    }

    @Override
    public AccessResponse patch(UUID id, AccessFilterRequest accessFilterRequest) {
        return null;
    }

    @Override
    public DeleteDto delete(UUID id) {
        Access access = findEntityById(
                accessRepository,
                id,
                i18nConfig.getMessage("error.access.not_found"));

        accessRepository.delete(access);

        return new DeleteDto(i18nConfig.getMessage("success.access.deleted"));
    }

}
