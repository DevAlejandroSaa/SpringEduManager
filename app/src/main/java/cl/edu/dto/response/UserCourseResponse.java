package cl.edu.dto.response;

import java.util.UUID;

public record UserCourseResponse(
    UUID id,
    UUID studentUserId,
    UUID courseOfferingId
) {}
