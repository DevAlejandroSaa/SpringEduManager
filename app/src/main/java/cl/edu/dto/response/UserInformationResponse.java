package cl.edu.dto.response;

import java.util.UUID;

public record UserInformationResponse(
    UUID id,
    String firstName,
    String lastName,
    String email
) {}
