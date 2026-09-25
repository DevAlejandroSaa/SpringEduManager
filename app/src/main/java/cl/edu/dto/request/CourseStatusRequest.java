package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseStatusRequest(
    @NotBlank(message = "{valid.course_status.required}")
    @Size(max = 50, message = "{valid.course_status.size}")
    String code,

    @NotBlank(message = "{valid.course_status.required}")
    @Size(max = 100, message = "{valid.course_status.size}")
    String name,

    @NotBlank(message = "{valid.course_status.required}")
    @Size(max = 255, message = "{valid.course_status.size}")
    String description
) {}
