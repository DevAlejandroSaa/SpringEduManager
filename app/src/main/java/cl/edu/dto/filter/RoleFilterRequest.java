package cl.edu.dto.filter;

import jakarta.validation.constraints.Size;

public record RoleFilterRequest(
    @Size(max = 50, message = "{valid.role.size}")
    String code,

    @Size(max = 100, message = "{valid.role.size}")
    String name,

    @Size(max = 255, message = "{valid.role.size}")
    String description,

    Boolean active
) {}
