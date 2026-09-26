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
import cl.edu.dto.filter.AccessStatusFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessStatusRequest;
import cl.edu.dto.response.AccessStatusResponse;
import cl.edu.service.AccessStatusService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/access-status")
@RequiredArgsConstructor
public class AccessStatusController {

    @Qualifier("v1/AccessStatusService")
    private final AccessStatusService accessStatusService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.access_status.create.summary}",
        description = "${controller.operation.access_status.create.description}",
        operationId = "create",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.CREATED)
    public AccessStatusResponse create(@Valid @RequestBody AccessStatusRequest accessStatusRequest) {
        return accessStatusService.create(accessStatusRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.access_status.filter.summary}",
        description = "${controller.operation.access_status.filter.description}",
        operationId = "filter",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AccessStatusResponse> filter(@Valid @RequestBody PageRequest<AccessStatusFilterRequest> pageRequest) {
        return accessStatusService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_status.get_by_id.summary}",
        description = "${controller.operation.access_status.get_by_id.description}",
        operationId = "getById",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.OK)
    public AccessStatusResponse getById(@PathVariable UUID id) {
        return accessStatusService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_status.update.summary}",
        description = "${controller.operation.access_status.update.description}",
        operationId = "update",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.OK)
    public AccessStatusResponse update(@PathVariable UUID id, @Valid @RequestBody AccessStatusRequest accessStatusRequest) {
        return accessStatusService.update(id, accessStatusRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_status.patch.summary}",
        description = "${controller.operation.access_status.patch.description}",
        operationId = "patch",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.OK)
    public AccessStatusResponse patch(@PathVariable UUID id, @Valid @RequestBody AccessStatusFilterRequest accessStatusFilterRequest) {
        return accessStatusService.patch(id, accessStatusFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_status.delete.summary}",
        description = "${controller.operation.access_status.delete.description}",
        operationId = "delete",
        tags = {"Access Status"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return accessStatusService.delete(id);
    }

}
