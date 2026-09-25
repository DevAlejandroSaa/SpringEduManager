package cl.edu.dto.filter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record GradeRuleFilterRequest(
    @Min(value = 100, message = "{valid.grade_rule.min}")
    @Max(value = 700, message = "{valid.grade_rule.max}")
    Short grade,

    Boolean approved
) {}
