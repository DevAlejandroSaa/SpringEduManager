package cl.edu.dto.response;

import java.util.UUID;

public record CourseResponse(
    UUID id,
    UUID academicProgramId,
    String code,
    String name,
    String description,
    UUID statusId
) {}
