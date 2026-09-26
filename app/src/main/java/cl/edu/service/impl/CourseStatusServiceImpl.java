package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.CourseStatusSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseStatusRequest;
import cl.edu.dto.response.CourseStatusResponse;
import cl.edu.entity.CourseStatus;
import cl.edu.mapper.CourseStatusMapper;
import cl.edu.repository.CourseStatusRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.CourseStatusService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/CourseStatusService")
@RequiredArgsConstructor
@Transactional
public class CourseStatusServiceImpl extends AbstractService implements CourseStatusService {

    private final CourseStatusRepository courseStatusRepository;
    private final CourseStatusMapper courseStatusMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public CourseStatusResponse create(CourseStatusRequest courseStatusRequest) {
        if (this.courseStatusRepository.existsByCode(courseStatusRequest.code())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.code_exists"));
        }
        if (this.courseStatusRepository.existsByName(courseStatusRequest.name())) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.name_exists"));
        }
        CourseStatus courseStatus = this.courseStatusMapper.toEntity(courseStatusRequest);
        return this.courseStatusMapper.toResponse(this.courseStatusRepository.save(courseStatus));
    }

    @Override
    public PageResponse<CourseStatusResponse> filter(PageRequest<CourseStatusFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                CourseStatus.class,
                pageRequest,
                CourseStatusSpecification::apply,
                this.courseStatusMapper::toResponse);
    }

    @Override
    public CourseStatusResponse getById(UUID id) {
        CourseStatus courseStatus = findEntityById(
                this.courseStatusRepository,
                id,
                this.i18nConfig.getMessage("error.course_status.not_found"));
        return this.courseStatusMapper.toResponse(courseStatus);
    }

    @Override
    public CourseStatusResponse update(UUID id, CourseStatusRequest courseStatusRequest) {
        CourseStatus courseStatus = findEntityById(
                this.courseStatusRepository,
                id,
                this.i18nConfig.getMessage("error.course_status.not_found"));
        if (this.courseStatusRepository.existsByCodeAndIdNot(courseStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.code_exists"));
        }
        if (this.courseStatusRepository.existsByNameAndIdNot(courseStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.name_exists"));
        }
        this.courseStatusMapper.updateEntityFromRequest(courseStatusRequest, courseStatus);
        return this.courseStatusMapper.toResponse(this.courseStatusRepository.save(courseStatus));
    }

    @Override
    public CourseStatusResponse patch(UUID id, CourseStatusFilterRequest courseStatusFilterRequest) {
        CourseStatus courseStatus = findEntityById(
                this.courseStatusRepository,
                id,
                this.i18nConfig.getMessage("error.course_status.not_found"));
        CourseStatusRequest courseStatusRequest = this.courseStatusMapper.toRequest(courseStatusFilterRequest);
        if (courseStatusRequest.code() != null && this.courseStatusRepository.existsByCodeAndIdNot(courseStatusRequest.code(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.code_exists"));
        }
        if (courseStatusRequest.name() != null && this.courseStatusRepository.existsByNameAndIdNot(courseStatusRequest.name(), id)) {
            throw new CustomConflictException(this.i18nConfig.getMessage("error.course_status.name_exists"));
        }
        this.courseStatusMapper.updateEntityFromRequest(courseStatusRequest, courseStatus);
        return this.courseStatusMapper.toResponse(this.courseStatusRepository.save(courseStatus));
    }

    @Override
    public DeleteDto delete(UUID id) {
        CourseStatus courseStatus = findEntityById(
                this.courseStatusRepository,
                id,
                this.i18nConfig.getMessage("error.course_status.not_found"));
        this.courseStatusRepository.delete(courseStatus);
        return new DeleteDto(this.i18nConfig.getMessage("success.course_status.deleted"));
    }

}
