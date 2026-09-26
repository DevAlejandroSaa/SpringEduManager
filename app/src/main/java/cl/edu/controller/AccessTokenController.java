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
import cl.edu.dto.filter.AccessTokenFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.AccessTokenRequest;
import cl.edu.dto.response.AccessTokenResponse;
import cl.edu.service.AccessTokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/access-token")
@RequiredArgsConstructor
public class AccessTokenController {

    @Qualifier("v1/AccessTokenService")
    private final AccessTokenService accessTokenService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.access_token.create.summary}",
        description = "${controller.operation.access_token.create.description}",
        operationId = "create",
        tags = {"Access Token"})
    @ResponseStatus(HttpStatus.CREATED)
    public AccessTokenResponse create(@Valid @RequestBody AccessTokenRequest accessTokenRequest) {
        return accessTokenService.create(accessTokenRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.access_token.filter.summary}",
        description = "${controller.operation.access_token.filter.description}",
        operationId = "filter",
        tags = {"Access Token"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<AccessTokenResponse> filter(@Valid @RequestBody PageRequest<AccessTokenFilterRequest> pageRequest) {
        return accessTokenService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_token.get_by_id.summary}",
        description = "${controller.operation.access_token.get_by_id.description}",
        operationId = "getById",
        tags = {"Access Token"})
    @ResponseStatus(HttpStatus.OK)
    public AccessTokenResponse getById(@PathVariable UUID id) {
        return accessTokenService.getById(id);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.access_token.delete.summary}",
        description = "${controller.operation.access_token.delete.description}",
        operationId = "delete",
        tags = {"Access Token"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return accessTokenService.delete(id);
    }

}
