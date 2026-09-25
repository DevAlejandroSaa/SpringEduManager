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
import cl.edu.dto.filter.PracticeStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeStatusRequest;
import cl.edu.dto.response.PracticeStatusResponse;
import cl.edu.service.PracticeStatusService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/practice-status")
@RequiredArgsConstructor
public class PracticeStatusController {

    @Qualifier("v1/PracticeStatusService")
    private final PracticeStatusService practiceStatusService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.practice_status.create.summary}",
        description = "${controller.operation.practice_status.create.description}",
        operationId = "create",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.CREATED)
    public PracticeStatusResponse create(@Valid @RequestBody PracticeStatusRequest practiceStatusRequest) {
        return practiceStatusService.create(practiceStatusRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.practice_status.filter.summary}",
        description = "${controller.operation.practice_status.filter.description}",
        operationId = "filter",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<PracticeStatusResponse> filter(@Valid @RequestBody PageRequest<PracticeStatusFilterRequest> pageRequest) {
        return practiceStatusService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_status.get_by_id.summary}",
        description = "${controller.operation.practice_status.get_by_id.description}",
        operationId = "getById",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeStatusResponse getById(@PathVariable UUID id) {
        return practiceStatusService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_status.update.summary}",
        description = "${controller.operation.practice_status.update.description}",
        operationId = "update",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeStatusResponse update(@PathVariable UUID id, @Valid @RequestBody PracticeStatusRequest practiceStatusRequest) {
        return practiceStatusService.update(id, practiceStatusRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_status.patch.summary}",
        description = "${controller.operation.practice_status.patch.description}",
        operationId = "patch",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeStatusResponse patch(@PathVariable UUID id, @Valid @RequestBody PracticeStatusFilterRequest practiceStatusFilterRequest) {
        return practiceStatusService.patch(id, practiceStatusFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice_status.delete.summary}",
        description = "${controller.operation.practice_status.delete.description}",
        operationId = "delete",
        tags = {"Practice Status"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return practiceStatusService.delete(id);
    }

}
