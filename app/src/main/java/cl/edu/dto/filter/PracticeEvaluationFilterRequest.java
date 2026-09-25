package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record PracticeEvaluationFilterRequest(
    UUID userPracticeId,

    @Min(value = 100, message = "{valid.practice_evaluation.min}")
    @Max(value = 700, message = "{valid.practice_evaluation.max}")
    Short grade,

    @Size(max = 255, message = "{valid.practice_evaluation.size}")
    String description
) {}
