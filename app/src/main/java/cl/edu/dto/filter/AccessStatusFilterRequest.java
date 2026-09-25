package cl.edu.dto.filter;

import jakarta.validation.constraints.Size;

public record AccessStatusFilterRequest(
    @Size(max = 50, message = "{valid.access_status.size}")
    String code,

    @Size(max = 100, message = "{valid.access_status.size}")
    String name,

    @Size(max = 255, message = "{valid.access_status.size}")
    String description
) {}
