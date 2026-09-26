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
import cl.edu.dto.filter.UserPracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserPracticeRequest;
import cl.edu.dto.response.UserPracticeResponse;
import cl.edu.service.UserPracticeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-practice")
@RequiredArgsConstructor
public class UserPracticeController {

    @Qualifier("v1/UserPracticeService")
    private final UserPracticeService userPracticeService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.user_practice.create.summary}",
        description = "${controller.operation.user_practice.create.description}",
        operationId = "create",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.CREATED)
    public UserPracticeResponse create(@Valid @RequestBody UserPracticeRequest userPracticeRequest) {
        return userPracticeService.create(userPracticeRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.user_practice.filter.summary}",
        description = "${controller.operation.user_practice.filter.description}",
        operationId = "filter",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<UserPracticeResponse> filter(@Valid @RequestBody PageRequest<UserPracticeFilterRequest> pageRequest) {
        return userPracticeService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_practice.get_by_id.summary}",
        description = "${controller.operation.user_practice.get_by_id.description}",
        operationId = "getById",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.OK)
    public UserPracticeResponse getById(@PathVariable UUID id) {
        return userPracticeService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_practice.update.summary}",
        description = "${controller.operation.user_practice.update.description}",
        operationId = "update",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.OK)
    public UserPracticeResponse update(@PathVariable UUID id, @Valid @RequestBody UserPracticeRequest userPracticeRequest) {
        return userPracticeService.update(id, userPracticeRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_practice.patch.summary}",
        description = "${controller.operation.user_practice.patch.description}",
        operationId = "patch",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.OK)
    public UserPracticeResponse patch(@PathVariable UUID id, @Valid @RequestBody UserPracticeFilterRequest userPracticeFilterRequest) {
        return userPracticeService.patch(id, userPracticeFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_practice.delete.summary}",
        description = "${controller.operation.user_practice.delete.description}",
        operationId = "delete",
        tags = {"User Practice"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return userPracticeService.delete(id);
    }

}
