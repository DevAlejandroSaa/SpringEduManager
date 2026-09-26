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
import cl.edu.dto.filter.PracticeEvaluationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeEvaluationRequest;
import cl.edu.dto.response.PracticeEvaluationResponse;
import cl.edu.service.PracticeEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/practice-evaluation")
@RequiredArgsConstructor
public class PracticeEvaluationController {

    @Qualifier("v1/PracticeEvaluationService")
    private final PracticeEvaluationService practiceEvaluationService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.create.summary}",
        description = "${controller.operation.practice_evaluation.create.description}",
        operationId = "create",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.CREATED)
    public PracticeEvaluationResponse create(@Valid @RequestBody PracticeEvaluationRequest practiceEvaluationRequest) {
        return practiceEvaluationService.create(practiceEvaluationRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.filter.summary}",
        description = "${controller.operation.practice_evaluation.filter.description}",
        operationId = "filter",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<PracticeEvaluationResponse> filter(@Valid @RequestBody PageRequest<PracticeEvaluationFilterRequest> pageRequest) {
        return practiceEvaluationService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.get_by_id.summary}",
        description = "${controller.operation.practice_evaluation.get_by_id.description}",
        operationId = "getById",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeEvaluationResponse getById(@PathVariable UUID id) {
        return practiceEvaluationService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.update.summary}",
        description = "${controller.operation.practice_evaluation.update.description}",
        operationId = "update",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeEvaluationResponse update(@PathVariable UUID id, @Valid @RequestBody PracticeEvaluationRequest practiceEvaluationRequest) {
        return practiceEvaluationService.update(id, practiceEvaluationRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.patch.summary}",
        description = "${controller.operation.practice_evaluation.patch.description}",
        operationId = "patch",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeEvaluationResponse patch(@PathVariable UUID id, @Valid @RequestBody PracticeEvaluationFilterRequest practiceEvaluationFilterRequest) {
        return practiceEvaluationService.patch(id, practiceEvaluationFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_evaluation.delete.summary}",
        description = "${controller.operation.practice_evaluation.delete.description}",
        operationId = "delete",
        tags = {"Practice Evaluation"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return practiceEvaluationService.delete(id);
    }

}
