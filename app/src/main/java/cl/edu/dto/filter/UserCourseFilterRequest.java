package cl.edu.dto.filter;

import java.util.UUID;

public record UserCourseFilterRequest(
    UUID studentUserId,
    UUID courseOfferingId
) {}
