package ml.cloverkit.validating;

public class CircularQueueException extends RuntimeException {
    public CircularQueueException(String why) {
        super(why);
    }
}
