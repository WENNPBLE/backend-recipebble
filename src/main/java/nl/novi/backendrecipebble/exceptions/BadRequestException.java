package nl.novi.backendrecipebble.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }
}
