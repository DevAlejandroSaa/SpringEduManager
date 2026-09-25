package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PracticeEvaluationRequest(
    @NotNull(message = "{valid.practice_evaluation.required}")
    UUID userPracticeId,

    @NotNull(message = "{valid.practice_evaluation.required}")
    @Min(value = 100, message = "{valid.practice_evaluation.min}")
    @Max(value = 700, message = "{valid.practice_evaluation.max}")
    Short grade,

    @NotBlank(message = "{valid.practice_evaluation.required}")
    @Size(max = 255, message = "{valid.practice_evaluation.size}")
    String description
) {}
