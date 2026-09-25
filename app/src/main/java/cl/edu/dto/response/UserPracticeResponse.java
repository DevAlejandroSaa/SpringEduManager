package cl.edu.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record UserPracticeResponse(
    UUID id,
    UUID studentUserId,
    UUID practiceId,
    LocalDate startDate,
    LocalDate endDate,
    String practiceLocation,
    String responsibleName,
    String responsibleEmail,
    String responsiblePhone
) {}
