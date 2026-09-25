package cl.edu.dto.response;

import java.util.UUID;

public record AcademicProgramResponse(
    UUID id,
    String code,
    String name,
    String description,
    UUID statusId
) {}
