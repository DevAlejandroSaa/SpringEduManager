package cl.edu.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AcademicProgramRequest(
    @NotBlank(message = "{valid.academic_program.required}")
    @Size(max = 50, message = "{valid.academic_program.size}")
    String code,

    @NotBlank(message = "{valid.academic_program.required}")
    @Size(max = 150, message = "{valid.academic_program.size}")
    String name,

    @NotBlank(message = "{valid.academic_program.required}")
    @Size(max = 255, message = "{valid.academic_program.size}")
    String description,

    @NotNull(message = "{valid.academic_program.required}")
    UUID statusId
) {}
