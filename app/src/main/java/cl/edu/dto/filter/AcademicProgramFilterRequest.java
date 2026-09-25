package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Size;

public record AcademicProgramFilterRequest(
    @Size(max = 50, message = "{valid.academic_program.size}")
    String code,

    @Size(max = 150, message = "{valid.academic_program.size}")
    String name,

    @Size(max = 255, message = "{valid.academic_program.size}")
    String description,

    UUID statusId
) {}
