package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AccessStatusRequest(
    @NotBlank(message = "{valid.access_status.required}")
    @Size(max = 50, message = "{valid.access_status.size}")
    String code,

    @NotBlank(message = "{valid.access_status.required}")
    @Size(max = 100, message = "{valid.access_status.size}")
    String name,

    @NotBlank(message = "{valid.access_status.required}")
    @Size(max = 255, message = "{valid.access_status.size}")
    String description
) {}
