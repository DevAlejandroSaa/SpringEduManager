package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleRequest(
    @NotBlank(message = "{valid.role.required}")
    @Size(max = 50, message = "{valid.role.size}")
    String code,

    @NotBlank(message = "{valid.role.required}")
    @Size(max = 100, message = "{valid.role.size}")
    String name,

    @Size(max = 255, message = "{valid.role.size}")
    String description,

    boolean active
) {}
