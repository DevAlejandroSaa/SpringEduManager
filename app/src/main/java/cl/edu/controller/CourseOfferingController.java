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
import cl.edu.dto.filter.CourseOfferingFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseOfferingRequest;
import cl.edu.dto.response.CourseOfferingResponse;
import cl.edu.service.CourseOfferingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-offering")
@RequiredArgsConstructor
public class CourseOfferingController {

    @Qualifier("v1/CourseOfferingService")
    private final CourseOfferingService courseOfferingService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.course_offering.create.summary}",
        description = "${controller.operation.course_offering.create.description}",
        operationId = "create",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.CREATED)
    public CourseOfferingResponse create(@Valid @RequestBody CourseOfferingRequest courseOfferingRequest) {
        return courseOfferingService.create(courseOfferingRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.course_offering.filter.summary}",
        description = "${controller.operation.course_offering.filter.description}",
        operationId = "filter",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CourseOfferingResponse> filter(@Valid @RequestBody PageRequest<CourseOfferingFilterRequest> pageRequest) {
        return courseOfferingService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_offering.get_by_id.summary}",
        description = "${controller.operation.course_offering.get_by_id.description}",
        operationId = "getById",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.OK)
    public CourseOfferingResponse getById(@PathVariable UUID id) {
        return courseOfferingService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_offering.update.summary}",
        description = "${controller.operation.course_offering.update.description}",
        operationId = "update",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.OK)
    public CourseOfferingResponse update(@PathVariable UUID id, @Valid @RequestBody CourseOfferingRequest courseOfferingRequest) {
        return courseOfferingService.update(id, courseOfferingRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_offering.patch.summary}",
        description = "${controller.operation.course_offering.patch.description}",
        operationId = "patch",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.OK)
    public CourseOfferingResponse patch(@PathVariable UUID id, @Valid @RequestBody CourseOfferingFilterRequest courseOfferingFilterRequest) {
        return courseOfferingService.patch(id, courseOfferingFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_offering.delete.summary}",
        description = "${controller.operation.course_offering.delete.description}",
        operationId = "delete",
        tags = {"Course Offering"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return courseOfferingService.delete(id);
    }

}
