package vn.scrip.buoi24.exception;
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}