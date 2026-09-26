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
import cl.edu.dto.filter.CourseEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.CourseEvaluationRequest;
import cl.edu.dto.response.CourseEvaluationResponse;
import cl.edu.service.CourseEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/course-evaluation")
@RequiredArgsConstructor
public class CourseEvaluationController {

    @Qualifier("v1/CourseEvaluationService")
    private final CourseEvaluationService courseEvaluationService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.course_evaluation.create.summary}",
        description = "${controller.operation.course_evaluation.create.description}",
        operationId = "create",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEvaluationResponse create(@Valid @RequestBody CourseEvaluationRequest courseEvaluationRequest) {
        return courseEvaluationService.create(courseEvaluationRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.course_evaluation.filter.summary}",
        description = "${controller.operation.course_evaluation.filter.description}",
        operationId = "filter",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CourseEvaluationResponse> filter(@Valid @RequestBody PageRequest<CourseEvaluationFilterRequest> pageRequest) {
        return courseEvaluationService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_evaluation.get_by_id.summary}",
        description = "${controller.operation.course_evaluation.get_by_id.description}",
        operationId = "getById",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public CourseEvaluationResponse getById(@PathVariable UUID id) {
        return courseEvaluationService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_evaluation.update.summary}",
        description = "${controller.operation.course_evaluation.update.description}",
        operationId = "update",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public CourseEvaluationResponse update(@PathVariable UUID id, @Valid @RequestBody CourseEvaluationRequest courseEvaluationRequest) {
        return courseEvaluationService.update(id, courseEvaluationRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_evaluation.patch.summary}",
        description = "${controller.operation.course_evaluation.patch.description}",
        operationId = "patch",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public CourseEvaluationResponse patch(@PathVariable UUID id, @Valid @RequestBody CourseEvaluationFilterRequest courseEvaluationFilterRequest) {
        return courseEvaluationService.patch(id, courseEvaluationFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.course_evaluation.delete.summary}",
        description = "${controller.operation.course_evaluation.delete.description}",
        operationId = "delete",
        tags = {"Course Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return courseEvaluationService.delete(id);
    }

}
