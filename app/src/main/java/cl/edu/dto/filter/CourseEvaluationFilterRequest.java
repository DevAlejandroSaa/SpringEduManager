package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CourseEvaluationFilterRequest(
    UUID userCourseId,

    @Min(value = 100, message = "{valid.course_evaluation.min}")
    @Max(value = 700, message = "{valid.course_evaluation.max}")
    Short grade
) {}
