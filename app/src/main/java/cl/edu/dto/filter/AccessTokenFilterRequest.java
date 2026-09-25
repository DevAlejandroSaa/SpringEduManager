package cl.edu.dto.filter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Size;

public record AccessTokenFilterRequest(
    UUID userInformationId,
    @Size(max = 512, message = "{valid.access_token.size}")
    String token,
    Boolean active,
    LocalDateTime expiresAt
) {}
