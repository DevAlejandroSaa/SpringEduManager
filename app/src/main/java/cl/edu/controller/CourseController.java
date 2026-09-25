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
import cl.edu.dto.filter.CourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseRequest;
import cl.edu.dto.response.CourseResponse;
import cl.edu.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course")
@RequiredArgsConstructor
public class CourseController {

    @Qualifier("v1/CourseService")
    private final CourseService courseService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.course.create.summary}",
        description = "${controller.operation.course.create.description}",
        operationId = "create",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CourseRequest courseRequest) {
        return courseService.create(courseRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.course.filter.summary}",
        description = "${controller.operation.course.filter.description}",
        operationId = "filter",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CourseResponse> filter(@Valid @RequestBody PageRequest<CourseFilterRequest> pageRequest) {
        return courseService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course.get_by_id.summary}",
        description = "${controller.operation.course.get_by_id.description}",
        operationId = "getById",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getById(@PathVariable UUID id) {
        return courseService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course.update.summary}",
        description = "${controller.operation.course.update.description}",
        operationId = "update",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse update(@PathVariable UUID id, @Valid @RequestBody CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course.patch.summary}",
        description = "${controller.operation.course.patch.description}",
        operationId = "patch",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse patch(@PathVariable UUID id, @Valid @RequestBody CourseFilterRequest courseFilterRequest) {
        return courseService.patch(id, courseFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course.delete.summary}",
        description = "${controller.operation.course.delete.description}",
        operationId = "delete",
        tags = {"Course"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return courseService.delete(id);
    }

}
