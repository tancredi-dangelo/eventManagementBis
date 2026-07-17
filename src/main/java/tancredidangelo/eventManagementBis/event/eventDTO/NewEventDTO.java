package tancredidangelo.eventManagementBis.event.eventDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import tancredidangelo.eventManagementBis.eventCreator.EventCreator;

import java.time.LocalDate;

public record NewEventDTO(
        @NotBlank String title,
        String description,
        @Future LocalDate date,
        @NotBlank String place,
        @NotBlank @Min(1) int capacity,
        EventCreator creator) {
}
