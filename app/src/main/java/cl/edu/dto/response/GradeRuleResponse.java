package cl.edu.dto.response;

import java.util.UUID;

public record GradeRuleResponse(
    UUID id,
    Short grade,
    boolean approved
) {}
