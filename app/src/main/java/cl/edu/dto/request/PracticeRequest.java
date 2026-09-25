package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PracticeRequest(
    @NotNull(message = "{valid.practice.required}")
    UUID academicProgramId,

    @NotBlank(message = "{valid.practice.required}")
    @Size(max = 50, message = "{valid.practice.size}")
    String code,

    @NotBlank(message = "{valid.practice.required}")
    @Size(max = 150, message = "{valid.practice.size}")
    String name,

    @NotBlank(message = "{valid.practice.required}")
    @Size(max = 255, message = "{valid.practice.size}")
    String description,

    @NotNull(message = "{valid.practice.required}")
    UUID statusId
) {}
