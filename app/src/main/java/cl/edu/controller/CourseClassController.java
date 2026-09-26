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
import cl.edu.dto.filter.CourseClassFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseClassRequest;
import cl.edu.dto.response.CourseClassResponse;
import cl.edu.service.CourseClassService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-class")
@RequiredArgsConstructor
public class CourseClassController {

    @Qualifier("v1/CourseClassService")
    private final CourseClassService courseClassService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.course_class.create.summary}",
        description = "${controller.operation.course_class.create.description}",
        operationId = "create",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.CREATED)
    public CourseClassResponse create(@Valid @RequestBody CourseClassRequest courseClassRequest) {
        return courseClassService.create(courseClassRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.course_class.filter.summary}",
        description = "${controller.operation.course_class.filter.description}",
        operationId = "filter",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CourseClassResponse> filter(@Valid @RequestBody PageRequest<CourseClassFilterRequest> pageRequest) {
        return courseClassService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_class.get_by_id.summary}",
        description = "${controller.operation.course_class.get_by_id.description}",
        operationId = "getById",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.OK)
    public CourseClassResponse getById(@PathVariable UUID id) {
        return courseClassService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_class.update.summary}",
        description = "${controller.operation.course_class.update.description}",
        operationId = "update",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.OK)
    public CourseClassResponse update(@PathVariable UUID id, @Valid @RequestBody CourseClassRequest courseClassRequest) {
        return courseClassService.update(id, courseClassRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_class.patch.summary}",
        description = "${controller.operation.course_class.patch.description}",
        operationId = "patch",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.OK)
    public CourseClassResponse patch(@PathVariable UUID id, @Valid @RequestBody CourseClassFilterRequest courseClassFilterRequest) {
        return courseClassService.patch(id, courseClassFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_class.delete.summary}",
        description = "${controller.operation.course_class.delete.description}",
        operationId = "delete",
        tags = {"Course Class"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return courseClassService.delete(id);
    }

}
