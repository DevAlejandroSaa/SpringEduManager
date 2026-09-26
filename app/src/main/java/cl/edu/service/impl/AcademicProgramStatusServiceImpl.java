package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.AcademicProgramStatusSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramStatusRequest;
import cl.edu.dto.response.AcademicProgramStatusResponse;
import cl.edu.entity.AcademicProgramStatus;
import cl.edu.mapper.AcademicProgramStatusMapper;
import cl.edu.repository.AcademicProgramStatusRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.AcademicProgramStatusService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/AcademicProgramStatusService")
@RequiredArgsConstructor
public class AcademicProgramStatusServiceImpl extends AbstractService implements AcademicProgramStatusService {

    private final AcademicProgramStatusRepository academicProgramStatusRepository;
    private final AcademicProgramStatusMapper academicProgramStatusMapper;
    private final I18nConfig i18nConfig;
    private final BlazeHelper blazeHelper;

    @Override
    public AcademicProgramStatusResponse create(AcademicProgramStatusRequest academicProgramStatusRequest) {
        if (this.academicProgramStatusRepository.existsByCode(academicProgramStatusRequest.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.code_exists"));
        }

        if (this.academicProgramStatusRepository.existsByName(academicProgramStatusRequest.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.name_exists"));
        }

        AcademicProgramStatus academicProgramStatus = this.academicProgramStatusMapper.toEntity(academicProgramStatusRequest);

        return this.academicProgramStatusMapper.toResponse(this.academicProgramStatusRepository.save(academicProgramStatus));
    }

    @Override
    public PageResponse<AcademicProgramStatusResponse> filter(PageRequest<AcademicProgramStatusFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                AcademicProgramStatus.class,
                pageRequest,
                AcademicProgramStatusSpecification::apply,
                academicProgramStatusMapper::toResponse);
    }

    @Override
    public AcademicProgramStatusResponse getById(UUID id) {
        AcademicProgramStatus academicProgramStatus = findEntityById(
            academicProgramStatusRepository,
            id,
            this.i18nConfig.getMessage("error.academic_program_status.not_found"));

        return this.academicProgramStatusMapper.toResponse(academicProgramStatus);
    }

    @Override
    public AcademicProgramStatusResponse update(UUID id, AcademicProgramStatusRequest academicProgramStatusRequest) {
        AcademicProgramStatus academicProgramStatus = findEntityById(
                academicProgramStatusRepository,
                id,
                this.i18nConfig.getMessage("error.academic_program_status.not_found"));

        if (this.academicProgramStatusRepository.existsByCodeAndIdNot(academicProgramStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.code_exists"));
        }

        if (this.academicProgramStatusRepository.existsByNameAndIdNot(academicProgramStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.name_exists"));
        }

        this.academicProgramStatusMapper.updateEntityFromRequest(academicProgramStatusRequest, academicProgramStatus);

        return this.academicProgramStatusMapper.toResponse(this.academicProgramStatusRepository.save(academicProgramStatus));
    }

    @Override
    public AcademicProgramStatusResponse patch(UUID id, AcademicProgramStatusFilterRequest academicProgramStatusFilterRequest) {
        AcademicProgramStatus academicProgramStatus = findEntityById(
                academicProgramStatusRepository,
                id,
                this.i18nConfig.getMessage("error.academic_program_status.not_found"));

        AcademicProgramStatusRequest academicProgramStatusRequest = this.academicProgramStatusMapper.toRequest(academicProgramStatusFilterRequest);

        if (academicProgramStatusRequest.code() != null && this.academicProgramStatusRepository.existsByCodeAndIdNot(academicProgramStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.code_exists"));
        }

        if (academicProgramStatusRequest.name() != null && this.academicProgramStatusRepository.existsByNameAndIdNot(academicProgramStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.name_exists"));
        }

        this.academicProgramStatusMapper.updateEntityFromRequest(academicProgramStatusRequest, academicProgramStatus);

        return this.academicProgramStatusMapper.toResponse(this.academicProgramStatusRepository.save(academicProgramStatus));
    }

    @Override
    public DeleteDto delete(UUID id) {
        AcademicProgramStatus academicProgramStatus = findEntityById(
            academicProgramStatusRepository,
            id,
            this.i18nConfig.getMessage("error.academic_program_status.not_found"));

        this.academicProgramStatusRepository.delete(academicProgramStatus);

        return new DeleteDto(this.i18nConfig.getMessage("success.academic_program_status.deleted"));
    }

}
