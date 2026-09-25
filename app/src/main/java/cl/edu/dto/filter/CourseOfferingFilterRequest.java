package cl.edu.dto.filter;

import java.time.LocalDate;
import java.util.UUID;

public record CourseOfferingFilterRequest(
    UUID courseId,
    UUID teacherUserId,
    LocalDate startDate,
    LocalDate endDate
) {}
