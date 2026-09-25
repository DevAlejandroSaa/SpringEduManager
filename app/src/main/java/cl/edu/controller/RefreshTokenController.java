package cl.edu.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.RefreshTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.RefreshTokenRequest;
import cl.edu.dto.response.RefreshTokenResponse;
import cl.edu.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/refresh-token")
@RequiredArgsConstructor
public class RefreshTokenController {

    @Qualifier("v1/RefreshTokenService")
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.refresh_token.create.summary}",
        description = "${controller.operation.refresh_token.create.description}",
        operationId = "create",
        tags = {"Refresh Token"})
    @ResponseStatus(HttpStatus.CREATED)
    public RefreshTokenResponse create(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return refreshTokenService.create(refreshTokenRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.refresh_token.filter.summary}",
        description = "${controller.operation.refresh_token.filter.description}",
        operationId = "filter",
        tags = {"Refresh Token"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<RefreshTokenResponse> filter(@Valid @RequestBody PageRequest<RefreshTokenFilterRequest> pageRequest) {
        return refreshTokenService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.refresh_token.get_by_id.summary}",
        description = "${controller.operation.refresh_token.get_by_id.description}",
        operationId = "getById",
        tags = {"Refresh Token"})
    @ResponseStatus(HttpStatus.OK)
    public RefreshTokenResponse getById(@PathVariable UUID id) {
        return refreshTokenService.getById(id);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.refresh_token.delete.summary}",
        description = "${controller.operation.refresh_token.delete.description}",
        operationId = "delete",
        tags = {"Refresh Token"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return refreshTokenService.delete(id);
    }

}
