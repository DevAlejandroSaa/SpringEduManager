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
import cl.edu.dto.filter.AcademicProgramFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramRequest;
import cl.edu.dto.response.AcademicProgramResponse;
import cl.edu.service.AcademicProgramService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/academic-program")
@RequiredArgsConstructor
public class AcademicProgramController {

    @Qualifier("v1/AcademicProgramService")
    private final AcademicProgramService academicProgramService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.academic_program.create.summary}",
        description = "${controller.operation.academic_program.create.description}",
        operationId = "create",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicProgramResponse create(@Valid @RequestBody AcademicProgramRequest academicProgramRequest) {
        return academicProgramService.create(academicProgramRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.academic_program.filter.summary}",
        description = "${controller.operation.academic_program.filter.description}",
        operationId = "filter",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AcademicProgramResponse> filter(@Valid @RequestBody PageRequest<AcademicProgramFilterRequest> pageRequest) {
        return academicProgramService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program.get_by_id.summary}",
        description = "${controller.operation.academic_program.get_by_id.description}",
        operationId = "getById",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramResponse getById(@PathVariable UUID id) {
        return academicProgramService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program.update.summary}",
        description = "${controller.operation.academic_program.update.description}",
        operationId = "update",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramResponse update(@PathVariable UUID id, @Valid @RequestBody AcademicProgramRequest academicProgramRequest) {
        return academicProgramService.update(id, academicProgramRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program.patch.summary}",
        description = "${controller.operation.academic_program.patch.description}",
        operationId = "patch",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramResponse patch(@PathVariable UUID id, @Valid @RequestBody AcademicProgramFilterRequest academicProgramFilterRequest) {
        return academicProgramService.patch(id, academicProgramFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program.delete.summary}",
        description = "${controller.operation.academic_program.delete.description}",
        operationId = "delete",
        tags = {"Academic Program"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return academicProgramService.delete(id);
    }

}
