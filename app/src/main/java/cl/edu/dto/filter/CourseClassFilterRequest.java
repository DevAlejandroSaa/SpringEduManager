package cl.edu.dto.filter;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.validation.constraints.Size;

public record CourseClassFilterRequest(
    UUID courseOfferingId,

    @Size(max = 20, message = "{valid.course_class.size}")
    String classDate,

    LocalTime startTime,
    LocalTime endTime,

    @Size(max = 255, message = "{valid.course_class.size}")
    String virtualUrl
) {}
