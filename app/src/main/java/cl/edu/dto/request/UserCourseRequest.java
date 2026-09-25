package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record UserCourseRequest(
    @NotNull(message = "{valid.user_course.required}")
    UUID studentUserId,

    @NotNull(message = "{valid.user_course.required}")
    UUID courseOfferingId
) {}
