package cl.edu.dto.filter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserInformationFilterRequest(
    @Size(max = 100, message = "{valid.user_information.size}")
    String firstName,

    @Size(max = 100, message = "{valid.user_information.size}")
    String lastName,

    @Email(message = "{valid.user_information.email}")
    @Size(max = 255, message = "{valid.user_information.size}")
    String email
) {}
