package cl.edu.dto.response;

import java.util.UUID;

public record RegisterResponseDto(
        UUID userId,
        String username,
        String email,
        String message
) {
}
