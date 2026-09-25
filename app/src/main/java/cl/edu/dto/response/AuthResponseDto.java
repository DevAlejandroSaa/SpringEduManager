package cl.edu.dto.response;

import java.util.List;
import java.util.UUID;

public record AuthResponseDto(
        String accessToken,
        String refreshToken,
        String tokenType,
        long expiresIn,
        UUID userId,
        String username,
        String email,
        String fullName,
        List<String> roles
) {
}
