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
import cl.edu.dto.filter.RoleFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RoleRequest;
import cl.edu.dto.response.RoleResponse;
import cl.edu.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/role")
@RequiredArgsConstructor
public class RoleController {

    @Qualifier("v1/RoleService")
    private final RoleService roleService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.role.create.summary}", 
        description = "${controller.operation.role.create.description}", 
        operationId = "create", 
        tags = {"Role" })
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponse create(@Valid @RequestBody RoleRequest roleRequest) {
        return roleService.create(roleRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.role.filter.summary}", 
        description = "${controller.operation.role.filter.description}", 
        operationId = "filter", 
        tags = { "Role" })
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<RoleResponse> filter(@Valid @RequestBody PageRequest<RoleFilterRequest> pageRequest) {
        return roleService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.role.get_by_id.summary}", 
        description = "${controller.operation.role.get_by_id.description}", 
        operationId = "getById", tags = { "Role" })
    @ResponseStatus(HttpStatus.OK)
    public RoleResponse getById(@PathVariable UUID id) {
        return roleService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.role.update.summary}", 
        description = "${controller.operation.role.update.description}", 
        operationId = "update", 
        tags = { "Role" })
    @ResponseStatus(HttpStatus.OK)
    public RoleResponse update(@PathVariable UUID id, @Valid @RequestBody RoleRequest roleRequest) {
        return roleService.update(id, roleRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.role.patch.summary}", 
        description = "${controller.operation.role.patch.description}", 
        operationId = "patch", 
        tags = { "Role" })
    @ResponseStatus(HttpStatus.OK)
    public RoleResponse patch(@PathVariable UUID id, @Valid @RequestBody RoleFilterRequest roleFilterRequest) {
        return roleService.patch(id, roleFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.role.delete.summary}", 
        description = "${controller.operation.role.delete.description}", 
        operationId = "delete", 
        tags = { "Role" })
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return roleService.delete(id);
    }

}
