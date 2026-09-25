package cl.edu.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CourseOfferingRequest(
    @NotNull(message = "{valid.course_offering.required}")
    UUID courseId,

    @NotNull(message = "{valid.course_offering.required}")
    UUID teacherUserId,

    @NotNull(message = "{valid.course_offering.required}")
    LocalDate startDate,

    @NotNull(message = "{valid.course_offering.required}")
    LocalDate endDate
) {}
