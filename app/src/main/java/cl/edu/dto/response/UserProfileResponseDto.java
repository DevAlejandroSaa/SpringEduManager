package cl.edu.dto.response;

import java.util.List;
import java.util.UUID;

public record UserProfileResponseDto(
        UUID id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        String username,
        List<String> roles
) {
}
