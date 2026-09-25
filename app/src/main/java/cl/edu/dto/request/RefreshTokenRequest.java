package cl.edu.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RefreshTokenRequest(
    @NotNull(message = "{valid.refresh_token.required}")
    UUID userInformationId,

    @NotBlank(message = "{valid.refresh_token.required}")
    @Size(max = 512, message = "{valid.refresh_token.size}")
    String token,

    boolean active,

    @NotNull(message = "{valid.refresh_token.required}")
    LocalDateTime expiresAt
) {}
