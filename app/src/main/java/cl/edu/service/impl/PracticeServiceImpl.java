package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.PracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeRequest;
import cl.edu.dto.response.PracticeResponse;
import cl.edu.mapper.PracticeMapper;
import cl.edu.repository.PracticeRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.PracticeService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/PracticeService")
@RequiredArgsConstructor
@Transactional
public class PracticeServiceImpl extends AbstractService implements PracticeService {

    private final PracticeRepository practiceRepository;
    private final PracticeMapper practiceMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public PracticeResponse create(PracticeRequest practiceRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PageResponse<PracticeResponse> filter(PageRequest<PracticeFilterRequest> pageRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public PracticeResponse getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public PracticeResponse update(UUID id, PracticeRequest practiceRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public PracticeResponse patch(UUID id, PracticeFilterRequest practiceFilterRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public DeleteDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
