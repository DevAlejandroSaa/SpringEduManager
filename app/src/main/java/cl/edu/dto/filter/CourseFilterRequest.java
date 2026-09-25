package cl.edu.dto.filter;

import java.util.UUID;

import jakarta.validation.constraints.Size;

public record CourseFilterRequest(
    UUID academicProgramId,

    @Size(max = 50, message = "{valid.course.size}")
    String code,

    @Size(max = 150, message = "{valid.course.size}")
    String name,

    @Size(max = 255, message = "{valid.course.size}")
    String description,

    UUID statusId
) {}
