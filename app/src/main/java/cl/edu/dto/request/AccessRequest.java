package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccessRequest(
    @NotNull(message = "{valid.access.required}")
    UUID roleId,

    @NotNull(message = "{valid.access.required}")
    UUID userInformationId,

    @NotBlank(message = "{valid.access.required}")
    @Size(max = 100, message = "{valid.access.size}")
    String username,

    @NotBlank(message = "{valid.access.required}")
    @Size(max = 255, message = "{valid.access.size}")
    String password,

    @NotNull(message = "{valid.access.required}")
    UUID accessStatusId
) {}
