package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Size;

public record PracticeFilterRequest(
    UUID academicProgramId,

    @Size(max = 50, message = "{valid.practice.size}")
    String code,

    @Size(max = 150, message = "{valid.practice.size}")
    String name,

    @Size(max = 255, message = "{valid.practice.size}")
    String description,

    UUID statusId
) {}
