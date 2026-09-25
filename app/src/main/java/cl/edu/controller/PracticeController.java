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
import cl.edu.dto.filter.PracticeFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.PracticeRequest;
import cl.edu.dto.response.PracticeResponse;
import cl.edu.service.PracticeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/Practice")
@RequiredArgsConstructor
public class PracticeController {

    @Qualifier("v1/PracticeService")
    private final PracticeService practiceService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.practice.create.summary}",
        description = "${controller.operation.practice.create.description}",
        operationId = "create",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.CREATED)
    public PracticeResponse create(@Valid @RequestBody PracticeRequest practiceRequest) {
        return practiceService.create(practiceRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.practice.filter.summary}",
        description = "${controller.operation.practice.filter.description}",
        operationId = "filter",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<PracticeResponse> filter(@Valid @RequestBody PageRequest<PracticeFilterRequest> pageRequest) {
        return practiceService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice.get_by_id.summary}",
        description = "${controller.operation.practice.get_by_id.description}",
        operationId = "getById",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeResponse getById(@PathVariable UUID id) {
        return practiceService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice.update.summary}",
        description = "${controller.operation.practice.update.description}",
        operationId = "update",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeResponse update(@PathVariable UUID id, @Valid @RequestBody PracticeRequest practiceRequest) {
        return practiceService.update(id, practiceRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice.patch.summary}",
        description = "${controller.operation.practice.patch.description}",
        operationId = "patch",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.OK)
    public PracticeResponse patch(@PathVariable UUID id, @Valid @RequestBody PracticeFilterRequest practiceFilterRequest) {
        return practiceService.patch(id, practiceFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.practice.delete.summary}",
        description = "${controller.operation.practice.delete.description}",
        operationId = "delete",
        tags = {"Practice"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return practiceService.delete(id);
    }

}
