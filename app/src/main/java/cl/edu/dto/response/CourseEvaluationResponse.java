package cl.edu.dto.response;

import java.util.UUID;

public record CourseEvaluationResponse(
    UUID id,
    UUID userCourseId,
    Short grade
) {}
