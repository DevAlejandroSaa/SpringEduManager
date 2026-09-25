package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.exception.custom.CustomBadRequestException;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.exception.custom.CustomNotFoundException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.AcademicProgramStatusDto;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
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
    public AcademicProgramStatusDto create(AcademicProgramStatusDto academicProgramStatusDto) {
        
        if (academicProgramStatusDto.id() != null) {
            throw new CustomBadRequestException(
                    this.i18nConfig.getMessage("error.academic_program_status.id_must_be_null"));
        }

        if (this.academicProgramStatusRepository.existsByCode(academicProgramStatusDto.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.code_exists"));
        }

        if (this.academicProgramStatusRepository.existsByName(academicProgramStatusDto.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.academic_program_status.name_exists"));
        }

        // AcademicProgramStatus academicProgramStatus =
        // this.academicProgramStatusMapper.toEntity(academicProgramStatusDto);

        // academicProgramStatus =
        // this.academicProgramStatusRepository.save(academicProgramStatus);

        // return this.academicProgramStatusMapper.toDto(academicProgramStatus);
        return null;
    }

    @Override
    public AcademicProgramStatusDto findById(UUID id) {
        // return this.academicProgramStatusMapper.toDto(this.findEntityById(id));
        return null;
    }

    @Override
    public PageResponse<AcademicProgramStatusDto> findAllPaged(PageRequest<AcademicProgramStatusDto> pageRequest) {
        // return this.blazeHelper.findAllPaged(
        // AcademicProgramStatus.class,
        // pageRequest,
        // AcademicProgramStatusSpecification::apply,
        // this.academicProgramStatusMapper::toDto);
        return null;
    }

    @Override
    public AcademicProgramStatusDto update(AcademicProgramStatusDto academicProgramStatusDto) {
        return this.updateEntity(academicProgramStatusDto);
    }

    @Override
    public AcademicProgramStatusDto path(AcademicProgramStatusDto academicProgramStatusDto) {
        return this.updateEntity(academicProgramStatusDto);
    }

    @Override
    public DeleteDto delete(UUID id) {
        AcademicProgramStatus academicProgramStatus = this.findEntityById(id);
        this.academicProgramStatusRepository.delete(academicProgramStatus);
        return new DeleteDto(this.i18nConfig.getMessage("success.academic_program_status.deleted"));
    }

    private AcademicProgramStatus findEntityById(UUID id) {
        return this.academicProgramStatusRepository
                .findById(id)
                .orElseThrow(() -> new CustomNotFoundException(
                        this.i18nConfig.getMessage("error.academic_program_status.not_found")));
    }

    private AcademicProgramStatusDto updateEntity(AcademicProgramStatusDto dto) {
        AcademicProgramStatus entity = this.findEntityById(dto.id());

        if (dto.code() != null) {
            if (this.academicProgramStatusRepository.existsByCodeAndIdNot(dto.code(), dto.id())) {
                throw new CustomConflictException(
                        this.i18nConfig.getMessage("error.academic_program_status.code_exists"));
            }
        }

        if (dto.name() != null) {
            if (this.academicProgramStatusRepository.existsByNameAndIdNot(dto.name(), dto.id())) {
                throw new CustomConflictException(
                        this.i18nConfig.getMessage("error.academic_program_status.name_exists"));
            }
        }

        // this.academicProgramStatusMapper.updateEntityFromDto(dto, entity);

        // return
        // this.academicProgramStatusMapper.toDto(this.academicProgramStatusRepository.save(entity));

        return null;
    }

}
