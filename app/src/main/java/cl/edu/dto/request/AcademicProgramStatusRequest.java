package cl.edu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcademicProgramStatusRequest(
    @NotBlank(message = "{valid.academic_program_status.required}")
    @Size(max = 50, message = "{valid.academic_program_status.size}")
    String code,

    @NotBlank(message = "{valid.academic_program_status.required}")
    @Size(max = 100, message = "{valid.academic_program_status.size}")
    String name,

    @NotBlank(message = "{valid.academic_program_status.required}")
    @Size(max = 255, message = "{valid.academic_program_status.size}")
    String description
) {}
