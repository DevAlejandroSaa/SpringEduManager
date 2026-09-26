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
import cl.edu.dto.filter.AcademicProgramStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AcademicProgramStatusRequest;
import cl.edu.dto.response.AcademicProgramStatusResponse;
import cl.edu.service.AcademicProgramStatusService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/academic-program-status")
@RequiredArgsConstructor
public class AcademicProgramStatusController {

    @Qualifier("v1/AcademicProgramStatusService")
    private final AcademicProgramStatusService academicProgramStatusService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.academic_program_status.create.summary}",
        description = "${controller.operation.academic_program_status.create.description}",
        operationId = "create",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicProgramStatusResponse create(@Valid @RequestBody AcademicProgramStatusRequest academicProgramStatusRequest) {
        return academicProgramStatusService.create(academicProgramStatusRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.academic_program_status.filter.summary}",
        description = "${controller.operation.academic_program_status.filter.description}",
        operationId = "filter",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AcademicProgramStatusResponse> filter(@Valid @RequestBody PageRequest<AcademicProgramStatusFilterRequest> pageRequest) {
        return academicProgramStatusService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program_status.get_by_id.summary}",
        description = "${controller.operation.academic_program_status.get_by_id.description}",
        operationId = "getById",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramStatusResponse getById(@PathVariable UUID id) {
        return academicProgramStatusService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program_status.update.summary}",
        description = "${controller.operation.academic_program_status.update.description}",
        operationId = "update",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramStatusResponse update(@PathVariable UUID id, @Valid @RequestBody AcademicProgramStatusRequest academicProgramStatusRequest) {
        return academicProgramStatusService.update(id, academicProgramStatusRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program_status.patch.summary}",
        description = "${controller.operation.academic_program_status.patch.description}",
        operationId = "patch",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.OK)
    public AcademicProgramStatusResponse patch(@PathVariable UUID id, @Valid @RequestBody AcademicProgramStatusFilterRequest academicProgramStatusFilterRequest) {
        return academicProgramStatusService.patch(id, academicProgramStatusFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.academic_program_status.delete.summary}",
        description = "${controller.operation.academic_program_status.delete.description}",
        operationId = "delete",
        tags = {"Academic Program Status"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return academicProgramStatusService.delete(id);
    }

}
