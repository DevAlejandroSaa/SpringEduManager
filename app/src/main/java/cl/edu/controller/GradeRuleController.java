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
import cl.edu.dto.filter.GradeRuleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.GradeRuleRequest;
import cl.edu.dto.response.GradeRuleResponse;
import cl.edu.service.GradeRuleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/grade-rule")
@RequiredArgsConstructor
public class GradeRuleController {

    @Qualifier("v1/GradeRuleService")
    private final GradeRuleService gradeRuleService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.grade_rule.create.summary}",
        description = "${controller.operation.grade_rule.create.description}",
        operationId = "create",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.CREATED)
    public GradeRuleResponse create(@Valid @RequestBody GradeRuleRequest gradeRuleRequest) {
        return gradeRuleService.create(gradeRuleRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.grade_rule.filter.summary}",
        description = "${controller.operation.grade_rule.filter.description}",
        operationId = "filter",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<GradeRuleResponse> filter(@Valid @RequestBody PageRequest<GradeRuleFilterRequest> pageRequest) {
        return gradeRuleService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.grade_rule.get_by_id.summary}",
        description = "${controller.operation.grade_rule.get_by_id.description}",
        operationId = "getById",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.OK)
    public GradeRuleResponse getById(@PathVariable UUID id) {
        return gradeRuleService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.grade_rule.update.summary}",
        description = "${controller.operation.grade_rule.update.description}",
        operationId = "update",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.OK)
    public GradeRuleResponse update(@PathVariable UUID id, @Valid @RequestBody GradeRuleRequest gradeRuleRequest) {
        return gradeRuleService.update(id, gradeRuleRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.grade_rule.patch.summary}",
        description = "${controller.operation.grade_rule.patch.description}",
        operationId = "patch",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.OK)
    public GradeRuleResponse patch(@PathVariable UUID id, @Valid @RequestBody GradeRuleFilterRequest gradeRuleFilterRequest) {
        return gradeRuleService.patch(id, gradeRuleFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.grade_rule.delete.summary}",
        description = "${controller.operation.grade_rule.delete.description}",
        operationId = "delete",
        tags = {"Grade Rule"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return gradeRuleService.delete(id);
    }

}
