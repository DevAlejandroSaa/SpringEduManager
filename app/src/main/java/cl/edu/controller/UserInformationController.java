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
import cl.edu.dto.filter.UserInformationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserInformationRequest;
import cl.edu.dto.response.UserInformationResponse;
import cl.edu.service.UserInformationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-information")
@RequiredArgsConstructor
public class UserInformationController {

    @Qualifier("v1/UserInformationService")
    private final UserInformationService userInformationService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.user_information.create.summary}",
        description = "${controller.operation.user_information.create.description}",
        operationId = "create",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.CREATED)
    public UserInformationResponse create(@Valid @RequestBody UserInformationRequest userInformationRequest) {
        return userInformationService.create(userInformationRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.user_information.filter.summary}",
        description = "${controller.operation.user_information.filter.description}",
        operationId = "filter",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<UserInformationResponse> filter(@Valid @RequestBody PageRequest<UserInformationFilterRequest> pageRequest) {
        return userInformationService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_information.get_by_id.summary}",
        description = "${controller.operation.user_information.get_by_id.description}",
        operationId = "getById",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.OK)
    public UserInformationResponse getById(@PathVariable UUID id) {
        return userInformationService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_information.update.summary}",
        description = "${controller.operation.user_information.update.description}",
        operationId = "update",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.OK)
    public UserInformationResponse update(@PathVariable UUID id, @Valid @RequestBody UserInformationRequest userInformationRequest) {
        return userInformationService.update(id, userInformationRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_information.patch.summary}",
        description = "${controller.operation.user_information.patch.description}",
        operationId = "patch",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.OK)
    public UserInformationResponse patch(@PathVariable UUID id, @Valid @RequestBody UserInformationFilterRequest userInformationFilterRequest) {
        return userInformationService.patch(id, userInformationFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_information.delete.summary}",
        description = "${controller.operation.user_information.delete.description}",
        operationId = "delete",
        tags = {"User Information"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return userInformationService.delete(id);
    }

}
