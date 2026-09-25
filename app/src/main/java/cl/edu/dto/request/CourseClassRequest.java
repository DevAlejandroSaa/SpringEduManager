package cl.edu.dto.request;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseClassRequest(
    @NotNull(message = "{valid.course_class.required}")
    UUID courseOfferingId,

    @NotBlank(message = "{valid.course_class.required}")
    @Size(max = 20, message = "{valid.course_class.size}")
    String classDate,

    @NotNull(message = "{valid.course_class.required}")
    LocalTime startTime,

    @NotNull(message = "{valid.course_class.required}")
    LocalTime endTime,

    @NotBlank(message = "{valid.course_class.required}")
    @Size(max = 255, message = "{valid.course_class.size}")
    String virtualUrl
) {}
