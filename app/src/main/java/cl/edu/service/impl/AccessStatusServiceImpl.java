package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.AccessStatusSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AccessStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessStatusRequest;
import cl.edu.dto.response.AccessStatusResponse;
import cl.edu.entity.AccessStatus;
import cl.edu.mapper.AccessStatusMapper;
import cl.edu.repository.AccessStatusRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.AccessStatusService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/AccessStatusService")
@RequiredArgsConstructor
@Transactional
public class AccessStatusServiceImpl extends AbstractService implements AccessStatusService {

    private final AccessStatusRepository accessStatusRepository;
    private final AccessStatusMapper accessStatusMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public AccessStatusResponse create(AccessStatusRequest accessStatusRequest) {
        if (this.accessStatusRepository.existsByCode(accessStatusRequest.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.code_exists"));
        }

        if (this.accessStatusRepository.existsByName(accessStatusRequest.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.name_exists"));
        }

        AccessStatus accessStatus = this.accessStatusMapper.toEntity(accessStatusRequest);

        return this.accessStatusMapper.toResponse(this.accessStatusRepository.save(accessStatus));
    }

    @Override
    public PageResponse<AccessStatusResponse> filter(PageRequest<AccessStatusFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                AccessStatus.class,
                pageRequest,
                AccessStatusSpecification::apply,
                accessStatusMapper::toResponse);
    }

    @Override
    public AccessStatusResponse getById(UUID id) {
        AccessStatus accessStatus = findEntityById(
                accessStatusRepository,
                id,
                this.i18nConfig.getMessage("error.access_status.not_found"));

        return this.accessStatusMapper.toResponse(accessStatus);
    }

    @Override
    public AccessStatusResponse update(UUID id, AccessStatusRequest accessStatusRequest) {
        AccessStatus accessStatus = findEntityById(
                accessStatusRepository,
                id,
                this.i18nConfig.getMessage("error.access_status.not_found"));

        if (this.accessStatusRepository.existsByCodeAndIdNot(accessStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.code_exists"));
        }

        if (this.accessStatusRepository.existsByNameAndIdNot(accessStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.name_exists"));
        }

        this.accessStatusMapper.updateEntityFromRequest(accessStatusRequest, accessStatus);

        return this.accessStatusMapper.toResponse(this.accessStatusRepository.save(accessStatus));
    }

    @Override
    public AccessStatusResponse patch(UUID id, AccessStatusFilterRequest accessStatusFilterRequest) {
        AccessStatus accessStatus = findEntityById(
                accessStatusRepository,
                id,
                this.i18nConfig.getMessage("error.access_status.not_found"));

        AccessStatusRequest accessStatusRequest = this.accessStatusMapper.toRequest(accessStatusFilterRequest);

        if (accessStatusRequest.code() != null && this.accessStatusRepository.existsByCodeAndIdNot(accessStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.code_exists"));
        }

        if (accessStatusRequest.name() != null && this.accessStatusRepository.existsByNameAndIdNot(accessStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.access_status.name_exists"));
        }

        this.accessStatusMapper.updateEntityFromRequest(accessStatusRequest, accessStatus);

        return this.accessStatusMapper.toResponse(this.accessStatusRepository.save(accessStatus));
    }

    @Override
    public DeleteDto delete(UUID id) {
        AccessStatus accessStatus = findEntityById(
                accessStatusRepository,
                id,
                this.i18nConfig.getMessage("error.access_status.not_found"));

        this.accessStatusRepository.delete(accessStatus);

        return new DeleteDto(this.i18nConfig.getMessage("success.access_status.deleted"));
    }

}
