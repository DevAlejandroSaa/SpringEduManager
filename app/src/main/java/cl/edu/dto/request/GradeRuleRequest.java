package cl.edu.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record GradeRuleRequest(
    @NotNull(message = "{valid.grade_rule.required}")
    @Min(value = 100, message = "{valid.grade_rule.min}")
    @Max(value = 700, message = "{valid.grade_rule.max}")
    Short grade,

    boolean approved
) {}
