package exceptions;

public class NoParkingSpotFoundException extends Exception {

    public NoParkingSpotFoundException(String message) {
        super(message);
    }
}