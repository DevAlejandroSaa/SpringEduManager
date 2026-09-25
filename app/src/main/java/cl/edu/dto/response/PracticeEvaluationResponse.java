package cl.edu.dto.response;

import java.util.UUID;

public record PracticeEvaluationResponse(
    UUID id,
    UUID userPracticeId,
    Short grade,
    String description
) {}
