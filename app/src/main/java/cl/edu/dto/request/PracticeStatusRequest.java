package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PracticeStatusRequest(
    @NotBlank(message = "{valid.practice_status.required}")
    @Size(max = 50, message = "{valid.practice_status.size}")
    String code,

    @NotBlank(message = "{valid.practice_status.required}")
    @Size(max = 100, message = "{valid.practice_status.size}")
    String name,

    @NotBlank(message = "{valid.practice_status.required}")
    @Size(max = 255, message = "{valid.practice_status.size}")
    String description
) {}
