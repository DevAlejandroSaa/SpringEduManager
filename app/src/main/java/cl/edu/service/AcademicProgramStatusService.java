package cl.edu.service;

import java.util.UUID;

import cl.edu.dto.AcademicProgramStatusDto;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;

public interface AcademicProgramStatusService {

    public AcademicProgramStatusDto create(AcademicProgramStatusDto academicProgramStatusDto);

    public AcademicProgramStatusDto findById(UUID id);

    public PageResponse<AcademicProgramStatusDto> findAllPaged(PageRequest<AcademicProgramStatusDto> pageRequest);

    public AcademicProgramStatusDto update(AcademicProgramStatusDto academicProgramStatusDto);

    public AcademicProgramStatusDto path(AcademicProgramStatusDto academicProgramStatusDto);

    public DeleteDto delete(UUID id);

}
