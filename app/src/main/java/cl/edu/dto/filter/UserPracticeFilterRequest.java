package cl.edu.dto.filter;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserPracticeFilterRequest(
    UUID studentUserId,
    UUID practiceId,
    LocalDate startDate,
    LocalDate endDate,
    @Size(max = 255, message = "{valid.user_practice.size}")
    String practiceLocation,
    @Size(max = 200, message = "{valid.user_practice.size}")
    String responsibleName,
    @Email(message = "{valid.user_practice.email}")
    @Size(max = 255, message = "{valid.user_practice.size}")
    String responsibleEmail,
    @Size(max = 30, message = "{valid.user_practice.size}")
    String responsiblePhone
) {}
