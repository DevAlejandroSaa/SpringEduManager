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
import cl.edu.dto.filter.UserCourseFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserCourseRequest;
import cl.edu.dto.response.UserCourseResponse;
import cl.edu.service.UserCourseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user-course")
@RequiredArgsConstructor
public class UserCourseController {

    @Qualifier("v1/UserCourseService")
    private final UserCourseService userCourseService;

    @PostMapping("/")
    @Operation(
        summary = "${controller.operation.user_course.create.summary}",
        description = "${controller.operation.user_course.create.description}",
        operationId = "create",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.CREATED)
    public UserCourseResponse create(@Valid @RequestBody UserCourseRequest userCourseRequest) {
        return userCourseService.create(userCourseRequest);
    }

    @PostMapping("/filter/")
    @Operation(
        summary = "${controller.operation.user_course.filter.summary}",
        description = "${controller.operation.user_course.filter.description}",
        operationId = "filter",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<UserCourseResponse> filter(@Valid @RequestBody PageRequest<UserCourseFilterRequest> pageRequest) {
        return userCourseService.filter(pageRequest);
    }

    @GetMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_course.get_by_id.summary}",
        description = "${controller.operation.user_course.get_by_id.description}",
        operationId = "getById",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.OK)
    public UserCourseResponse getById(@PathVariable UUID id) {
        return userCourseService.getById(id);
    }

    @PutMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_course.update.summary}",
        description = "${controller.operation.user_course.update.description}",
        operationId = "update",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.OK)
    public UserCourseResponse update(@PathVariable UUID id, @Valid @RequestBody UserCourseRequest userCourseRequest) {
        return userCourseService.update(id, userCourseRequest);
    }

    @PatchMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_course.patch.summary}",
        description = "${controller.operation.user_course.patch.description}",
        operationId = "patch",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.OK)
    public UserCourseResponse patch(@PathVariable UUID id, @Valid @RequestBody UserCourseFilterRequest userCourseFilterRequest) {
        return userCourseService.patch(id, userCourseFilterRequest);
    }

    @DeleteMapping("/{id}/")
    @Operation(
        summary = "${controller.operation.user_course.delete.summary}",
        description = "${controller.operation.user_course.delete.description}",
        operationId = "delete",
        tags = {"User Course"})
    @ResponseStatus(HttpStatus.OK)
    public DeleteDto delete(@PathVariable UUID id) {
        return userCourseService.delete(id);
    }

}
