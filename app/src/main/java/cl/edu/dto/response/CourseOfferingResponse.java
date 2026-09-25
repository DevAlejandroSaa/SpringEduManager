package cl.edu.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record CourseOfferingResponse(
    UUID id,
    UUID courseId,
    UUID teacherUserId,
    LocalDate startDate,
    LocalDate endDate
) {}
