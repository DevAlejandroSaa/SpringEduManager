package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeStatusRequest;
import cl.edu.dto.response.PracticeStatusResponse;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<PracticeStatusResponse> filter(PageRequest<PracticeStatusFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public PracticeStatusResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public PracticeStatusResponse update(UUID id, PracticeStatusRequest practiceStatusRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public PracticeStatusResponse patch(UUID id, PracticeStatusFilterRequest practiceStatusFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
