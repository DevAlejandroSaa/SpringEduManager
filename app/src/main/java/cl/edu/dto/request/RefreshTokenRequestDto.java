package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequestDto(
        @NotBlank(message = "El refresh token es obligatorio")
        String refreshToken
) {
}
