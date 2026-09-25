package cl.edu.dto.response;

import java.util.UUID;

public record AccessResponse(
    UUID id,
    UUID roleId,
    UUID userInformationId,
    String username,
    UUID statusId
) {}
