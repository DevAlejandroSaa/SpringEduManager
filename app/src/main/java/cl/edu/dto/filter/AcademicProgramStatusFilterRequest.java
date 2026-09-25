package cl.edu.dto.filter;

import jakarta.validation.constraints.Size;

public record AcademicProgramStatusFilterRequest(
    @Size(max = 50, message = "{valid.academic_program_status.size}")
    String code,

    @Size(max = 100, message = "{valid.academic_program_status.size}")
    String name,

    @Size(max = 255, message = "{valid.academic_program_status.size}")
    String description
) {}
