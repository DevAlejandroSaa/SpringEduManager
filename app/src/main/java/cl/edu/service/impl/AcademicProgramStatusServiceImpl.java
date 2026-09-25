package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramStatusRequest;
import cl.edu.dto.response.AcademicProgramStatusResponse;
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
    public AcademicProgramStatusResponse create(AcademicProgramStatusRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<AcademicProgramStatusResponse> filter(
            PageRequest<AcademicProgramStatusFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public AcademicProgramStatusResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public AcademicProgramStatusResponse update(UUID id, AcademicProgramStatusRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public AcademicProgramStatusResponse patch(UUID id, AcademicProgramStatusFilterRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
