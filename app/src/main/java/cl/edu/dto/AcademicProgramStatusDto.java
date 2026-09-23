package cl.edu.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcademicProgramStatusDto(
        UUID id,
        @NotBlank @Size(max = 50) String code,
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Size(max = 255) String description) {
}
