package cl.edu.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccessTokenRequest(
    @NotNull(message = "{valid.access_token.required}")
    UUID userInformationId,

    @NotBlank(message = "{valid.access_token.required}")
    @Size(max = 512, message = "{valid.access_token.size}")
    String token,

    boolean active,

    @NotNull(message = "{valid.access_token.required}")
    LocalDateTime expiresAt
) {}
