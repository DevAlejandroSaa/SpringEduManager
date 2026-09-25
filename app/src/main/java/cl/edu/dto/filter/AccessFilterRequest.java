package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Size;

public record AccessFilterRequest(
    UUID roleId,
    UUID userInformationId,
    @Size(max = 100, message = "{valid.access.size}")
    String username,
    UUID statusId
) {}
