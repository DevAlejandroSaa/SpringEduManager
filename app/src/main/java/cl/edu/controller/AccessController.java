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
import cl.edu.dto.filter.AccessFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessRequest;
import cl.edu.dto.response.AccessResponse;
import cl.edu.service.AccessService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/access")
@RequiredArgsConstructor
public class AccessController {

    @Qualifier("v1/AccessService")
    private final AccessService accessService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.access.create.summary}",
        description = "${controller.operation.access.create.description}",
        operationId = "create",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.CREATED)
    public AccessResponse create(@Valid @RequestBody AccessRequest accessRequest) {
        return accessService.create(accessRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.access.filter.summary}",
        description = "${controller.operation.access.filter.description}",
        operationId = "filter",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AccessResponse> filter(@Valid @RequestBody PageRequest<AccessFilterRequest> pageRequest) {
        return accessService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access.get_by_id.summary}",
        description = "${controller.operation.access.get_by_id.description}",
        operationId = "getById",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.OK)
    public AccessResponse getById(@PathVariable UUID id) {
        return accessService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access.update.summary}",
        description = "${controller.operation.access.update.description}",
        operationId = "update",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.OK)
    public AccessResponse update(@PathVariable UUID id, @Valid @RequestBody AccessRequest accessRequest) {
        return accessService.update(id, accessRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access.patch.summary}",
        description = "${controller.operation.access.patch.description}",
        operationId = "patch",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.OK)
    public AccessResponse patch(@PathVariable UUID id, @Valid @RequestBody AccessFilterRequest accessFilterRequest) {
        return accessService.patch(id, accessFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access.delete.summary}",
        description = "${controller.operation.access.delete.description}",
        operationId = "delete",
        tags = {"Access"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return accessService.delete(id);
    }

}
