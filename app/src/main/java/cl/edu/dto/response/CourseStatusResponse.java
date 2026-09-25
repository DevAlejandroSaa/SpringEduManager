package cl.edu.dto.response;

import java.util.UUID;

public record CourseStatusResponse(
    UUID id,
    String code,
    String name,
    String description
) {}
