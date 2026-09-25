package cl.edu.dto.response;

import java.time.LocalTime;
import java.util.UUID;

public record CourseClassResponse(
    UUID id,
    UUID courseOfferingId,
    String classDate,
    LocalTime startTime,
    LocalTime endTime,
    String virtualUrl
) {}
