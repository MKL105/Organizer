package Exceptions;

/**
 * This class represents an exception that is thrown when a duration is negative.
 *
 * @author Markus Luethje
 */

public class NegativeDurationDataException extends Exception{

    public NegativeDurationDataException(String message) {
        super(message);
    }
}
