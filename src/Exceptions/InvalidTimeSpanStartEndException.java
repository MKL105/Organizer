package Exceptions;

/**
 * This class represents an exception that is thrown when the start of a timespan is after its end.
 *
 * @author Markus Luethje
 */

public class InvalidTimeSpanStartEndException extends Exception {

    public InvalidTimeSpanStartEndException (String message) {
        super(message);
    }
}
