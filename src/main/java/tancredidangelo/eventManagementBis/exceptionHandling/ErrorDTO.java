package tancredidangelo.eventManagementBis.exceptionHandling;

import java.time.LocalDateTime;

public record ErrorDTO(String message, LocalDateTime timeStamp) {
}
