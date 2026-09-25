package cl.edu.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.CourseStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseStatusRequest;
import cl.edu.dto.response.CourseStatusResponse;
import cl.edu.service.CourseStatusService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-status")
@RequiredArgsConstructor
public class CourseStatusController {

    @Qualifier("v1/CourseStatusService")
    private final CourseStatusService courseStatusService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.course_status.create.summary}",
        description = "${controller.operation.course_status.create.description}",
        operationId = "create",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.CREATED)
    public CourseStatusResponse create(@Valid @RequestBody CourseStatusRequest courseStatusRequest) {
        return courseStatusService.create(courseStatusRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.course_status.filter.summary}",
        description = "${controller.operation.course_status.filter.description}",
        operationId = "filter",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CourseStatusResponse> filter(@Valid @RequestBody PageRequest<CourseStatusFilterRequest> pageRequest) {
        return courseStatusService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_status.get_by_id.summary}",
        description = "${controller.operation.course_status.get_by_id.description}",
        operationId = "getById",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.OK)
    public CourseStatusResponse getById(@PathVariable UUID id) {
        return courseStatusService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_status.update.summary}",
        description = "${controller.operation.course_status.update.description}",
        operationId = "update",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.OK)
    public CourseStatusResponse update(@PathVariable UUID id, @Valid @RequestBody CourseStatusRequest courseStatusRequest) {
        return courseStatusService.update(id, courseStatusRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_status.patch.summary}",
        description = "${controller.operation.course_status.patch.description}",
        operationId = "patch",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.OK)
    public CourseStatusResponse patch(@PathVariable UUID id, @Valid @RequestBody CourseStatusFilterRequest courseStatusFilterRequest) {
        return courseStatusService.patch(id, courseStatusFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_status.delete.summary}",
        description = "${controller.operation.course_status.delete.description}",
        operationId = "delete",
        tags = {"Course Status"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return courseStatusService.delete(id);
    }

}
