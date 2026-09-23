package cl.edu.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.dto.AcademicProgramStatusDto;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.service.AcademicProgramStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/academic-program-status")
@RequiredArgsConstructor
public class AcademicProgramStatusController {

    @Qualifier("v1/AcademicProgramStatusService")
    private final AcademicProgramStatusService academicProgramStatusService;

    @PostMapping("/")
    @Operation(summary = "${controller.operation.academic_program_status.find_all_paged.summary}", description = "${controller.operation.academic_program_status.find_all_paged.description}", operationId = "findAllPaged", tags = {
            "Academic Program Status" })
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AcademicProgramStatusDto> findAllPaged(
            @Valid @RequestBody PageRequest<AcademicProgramStatusDto> pageRequest) {
        return this.academicProgramStatusService.findAllPaged(pageRequest);
    }

}
