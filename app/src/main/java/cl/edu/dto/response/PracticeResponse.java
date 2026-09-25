package cl.edu.dto.response;

import java.util.UUID;

public record PracticeResponse(
    UUID id,
    UUID academicProgramId,
    String code,
    String name,
    String description,
    UUID statusId
) {}
