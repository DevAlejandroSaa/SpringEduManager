package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AcademicProgramFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramRequest;
import cl.edu.dto.response.AcademicProgramResponse;
import cl.edu.mapper.AcademicProgramMapper;
import cl.edu.repository.AcademicProgramRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.AcademicProgramService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/AcademicProgramService")
@RequiredArgsConstructor
@Transactional
public class AcademicProgramServiceImpl extends AbstractService implements AcademicProgramService {

    private final AcademicProgramRepository academicProgramRepository;
    private final AcademicProgramMapper academicProgramMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public AcademicProgramResponse create(AcademicProgramRequest academicProgramRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<AcademicProgramResponse> filter(PageRequest<AcademicProgramFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public AcademicProgramResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public AcademicProgramResponse update(UUID id, AcademicProgramRequest academicProgramRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public AcademicProgramResponse patch(UUID id, AcademicProgramFilterRequest academicProgramFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
