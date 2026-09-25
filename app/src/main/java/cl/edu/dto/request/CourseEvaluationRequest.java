package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CourseEvaluationRequest(
    @NotNull(message = "{valid.course_evaluation.required}")
    UUID userCourseId,

    @NotNull(message = "{valid.course_evaluation.required}")
    @Min(value = 100, message = "{valid.course_evaluation.min}")
    @Max(value = 700, message = "{valid.course_evaluation.max}")
    Short grade
) {}
