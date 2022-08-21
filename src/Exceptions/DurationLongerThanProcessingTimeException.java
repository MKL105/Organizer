package Exceptions;

/**
 * This class represents an exception that is thrown when the duration of an event is longer than its processing time.
 *
 * @author Markus Luethje
 */

public class DurationLongerThanProcessingTimeException extends Exception {

    public DurationLongerThanProcessingTimeException(String message) {
        super(message);
    }
}
