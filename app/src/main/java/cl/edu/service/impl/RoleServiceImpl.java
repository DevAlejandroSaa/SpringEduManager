package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.RoleSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.RoleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RoleRequest;
import cl.edu.dto.response.RoleResponse;
import cl.edu.entity.Role;
import cl.edu.mapper.RoleMapper;
import cl.edu.repository.RoleRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.RoleService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/RoleService")
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl extends AbstractService implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        if (this.roleRepository.existsByCode(roleRequest.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.code_exists"));
        }

        if (this.roleRepository.existsByName(roleRequest.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.name_exists"));
        }

        Role role = this.roleMapper.toEntity(roleRequest);

        return this.roleMapper.toResponse(this.roleRepository.save(role));
    }

    @Override
    public PageResponse<RoleResponse> filter(PageRequest<RoleFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                Role.class,
                pageRequest,
                RoleSpecification::apply,
                this.roleMapper::toResponse);
    }

    @Override
    public RoleResponse getById(UUID id) {
        Role role = findEntityById(
                this.roleRepository,
                id,
                this.i18nConfig.getMessage("error.role.not_found"));

        return this.roleMapper.toResponse(role);
    }

    @Override
    public RoleResponse update(UUID id, RoleRequest roleRequest) {
        Role role = findEntityById(
                this.roleRepository,
                id,
                this.i18nConfig.getMessage("error.role.not_found"));

        if (this.roleRepository.existsByCodeAndIdNot(roleRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.code_exists"));
        }

        if (this.roleRepository.existsByNameAndIdNot(roleRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.name_exists"));
        }

        this.roleMapper.updateEntityFromRequest(roleRequest, role);

        return this.roleMapper.toResponse(this.roleRepository.save(role));
    }

    @Override
    public RoleResponse patch(UUID id, RoleFilterRequest roleFilterRequest) {
        Role role = findEntityById(
                this.roleRepository,
                id,
                this.i18nConfig.getMessage("error.role.not_found"));

        RoleRequest roleRequest = this.roleMapper.toRequest(roleFilterRequest);

        if (roleFilterRequest.code() != null
                && this.roleRepository.existsByCodeAndIdNot(roleFilterRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.code_exists"));
        }

        if (roleFilterRequest.name() != null
                && this.roleRepository.existsByNameAndIdNot(roleFilterRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.role.name_exists"));
        }

        this.roleMapper.updateEntityFromRequest(roleRequest, role);

        return this.roleMapper.toResponse(this.roleRepository.save(role));
    }

    @Override
    public DeleteDto delete(UUID id) {
        Role role = findEntityById(
                this.roleRepository,
                id,
                this.i18nConfig.getMessage("error.role.not_found"));

        this.roleRepository.delete(role);

        return new DeleteDto(this.i18nConfig.getMessage("success.role.deleted"));
    }

}
