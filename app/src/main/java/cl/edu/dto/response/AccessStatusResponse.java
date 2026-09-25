package cl.edu.dto.response;

import java.util.UUID;

public record AccessStatusResponse(
    UUID id,
    String code,
    String name,
    String description
) {}
