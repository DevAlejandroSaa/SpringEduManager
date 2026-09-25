package cl.edu.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserInformationRequest(
    @NotBlank(message = "{valid.user_information.required}")
    @Size(max = 100, message = "{valid.user_information.size}")
    String firstName,

    @NotBlank(message = "{valid.user_information.required}")
    @Size(max = 100, message = "{valid.user_information.size}")
    String lastName,

    @NotBlank(message = "{valid.user_information.required}")
    @Email(message = "{valid.user_information.email}")
    @Size(max = 255, message = "{valid.user_information.size}")
    String email
) {}
