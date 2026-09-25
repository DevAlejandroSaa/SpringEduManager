package cl.edu.dto.filter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Size;

public record RefreshTokenFilterRequest(
    UUID userInformationId,
    @Size(max = 512, message = "{valid.refresh_token.size}")
    String token,
    Boolean active,
    LocalDateTime expiresAt
) {}
