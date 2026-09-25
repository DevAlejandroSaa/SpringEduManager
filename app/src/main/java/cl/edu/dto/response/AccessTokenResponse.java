package cl.edu.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record AccessTokenResponse(
    UUID id,
    UUID userInformationId,
    String token,
    boolean active,
    LocalDateTime expiresAt
) {}
