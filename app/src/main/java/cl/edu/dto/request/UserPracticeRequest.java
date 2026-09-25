package cl.edu.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserPracticeRequest(
    @NotNull(message = "{valid.user_practice.required}")
    UUID studentUserId,

    @NotNull(message = "{valid.user_practice.required}")
    UUID practiceId,

    @NotNull(message = "{valid.user_practice.required}")
    LocalDate startDate,

    @NotNull(message = "{valid.user_practice.required}")
    LocalDate endDate,

    @NotBlank(message = "{valid.user_practice.required}")
    @Size(max = 255, message = "{valid.user_practice.size}")
    String practiceLocation,

    @NotBlank(message = "{valid.user_practice.required}")
    @Size(max = 200, message = "{valid.user_practice.size}")
    String responsibleName,

    @NotBlank(message = "{valid.user_practice.required}")
    @Email(message = "{valid.user_practice.email}")
    @Size(max = 255, message = "{valid.user_practice.size}")
    String responsibleEmail,

    @NotBlank(message = "{valid.user_practice.required}")
    @Size(max = 30, message = "{valid.user_practice.size}")
    String responsiblePhone
) {}
