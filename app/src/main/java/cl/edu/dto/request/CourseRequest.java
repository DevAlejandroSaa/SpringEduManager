package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequest(
    @NotNull(message = "{valid.course.required}")
    UUID academicProgramId,

    @NotBlank(message = "{valid.course.required}")
    @Size(max = 50, message = "{valid.course.size}")
    String code,

    @NotBlank(message = "{valid.course.required}")
    @Size(max = 150, message = "{valid.course.size}")
    String name,

    @NotBlank(message = "{valid.course.required}")
    @Size(max = 255, message = "{valid.course.size}")
    String description,

    @NotNull(message = "{valid.course.required}")
    UUID statusId
) {}
