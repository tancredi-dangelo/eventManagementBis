package tancredidangelo.eventManagementBis.eventCreator.eventCreatorDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record NewEventCreatorDTO(
        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank @Email String email,
        @NotBlank @Min(8) @Max(24) String password) {
}
