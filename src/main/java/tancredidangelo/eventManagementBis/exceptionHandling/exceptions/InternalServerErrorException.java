package tancredidangelo.eventManagementBis.exceptionHandling.exceptions;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
