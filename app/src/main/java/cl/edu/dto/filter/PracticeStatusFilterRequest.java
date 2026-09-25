package cl.edu.dto.filter;

import jakarta.validation.constraints.Size;

public record PracticeStatusFilterRequest(
    @Size(max = 50, message = "{valid.practice_status.size}")
    String code,

    @Size(max = 100, message = "{valid.practice_status.size}")
    String name,

    @Size(max = 255, message = "{valid.practice_status.size}")
    String description
) {}
