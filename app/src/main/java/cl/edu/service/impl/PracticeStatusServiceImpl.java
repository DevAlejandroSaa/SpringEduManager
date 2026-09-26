package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.PracticeStatusSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeStatusRequest;
import cl.edu.dto.response.PracticeStatusResponse;
import cl.edu.entity.PracticeStatus;
import cl.edu.mapper.PracticeStatusMapper;
import cl.edu.repository.PracticeStatusRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.PracticeStatusService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/PracticeStatusService")
@RequiredArgsConstructor
@Transactional
public class PracticeStatusServiceImpl extends AbstractService implements PracticeStatusService {

    private final PracticeStatusRepository practiceStatusRepository;
    private final PracticeStatusMapper practiceStatusMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public PracticeStatusResponse create(PracticeStatusRequest practiceStatusRequest) {
        if (this.practiceStatusRepository.existsByCode(practiceStatusRequest.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.code_exists"));
        }

        if (this.practiceStatusRepository.existsByName(practiceStatusRequest.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.name_exists"));
        }

        PracticeStatus practiceStatus = this.practiceStatusMapper.toEntity(practiceStatusRequest);

        return this.practiceStatusMapper.toResponse(this.practiceStatusRepository.save(practiceStatus));
    }

    @Override
    public PageResponse<PracticeStatusResponse> filter(PageRequest<PracticeStatusFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                PracticeStatus.class,
                pageRequest,
                PracticeStatusSpecification::apply,
                this.practiceStatusMapper::toResponse);
    }

    @Override
    public PracticeStatusResponse getById(UUID id) {
        PracticeStatus practiceStatus = findEntityById(
                this.practiceStatusRepository,
                id,
                this.i18nConfig.getMessage("error.practice_status.not_found"));

        return this.practiceStatusMapper.toResponse(practiceStatus);
    }

    @Override
    public PracticeStatusResponse update(UUID id, PracticeStatusRequest practiceStatusRequest) {
        PracticeStatus practiceStatus = findEntityById(
                this.practiceStatusRepository,
                id,
                this.i18nConfig.getMessage("error.practice_status.not_found"));

        if (this.practiceStatusRepository.existsByCodeAndIdNot(practiceStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.code_exists"));
        }

        if (this.practiceStatusRepository.existsByNameAndIdNot(practiceStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.name_exists"));
        }

        this.practiceStatusMapper.updateEntityFromRequest(practiceStatusRequest, practiceStatus);

        return this.practiceStatusMapper.toResponse(this.practiceStatusRepository.save(practiceStatus));
    }

    @Override
    public PracticeStatusResponse patch(UUID id, PracticeStatusFilterRequest practiceStatusFilterRequest) {
        PracticeStatus practiceStatus = findEntityById(
                this.practiceStatusRepository,
                id,
                this.i18nConfig.getMessage("error.practice_status.not_found"));

        PracticeStatusRequest practiceStatusRequest = this.practiceStatusMapper.toRequest(practiceStatusFilterRequest);

        if (practiceStatusRequest.code() != null
                && this.practiceStatusRepository.existsByCodeAndIdNot(practiceStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.code_exists"));
        }

        if (practiceStatusRequest.name() != null
                && this.practiceStatusRepository.existsByNameAndIdNot(practiceStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.practice_status.name_exists"));
        }

        this.practiceStatusMapper.updateEntityFromRequest(practiceStatusRequest, practiceStatus);

        return this.practiceStatusMapper.toResponse(this.practiceStatusRepository.save(practiceStatus));
    }

    @Override
    public DeleteDto delete(UUID id) {
        PracticeStatus practiceStatus = findEntityById(
                this.practiceStatusRepository,
                id,
                this.i18nConfig.getMessage("error.practice_status.not_found"));

        this.practiceStatusRepository.delete(practiceStatus);

        return new DeleteDto(this.i18nConfig.getMessage("success.practice_status.deleted"));
    }

}
