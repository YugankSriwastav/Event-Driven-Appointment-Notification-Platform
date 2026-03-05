package backendlove.appointment_system.exception;

public class EntryAlreadyCreated extends RuntimeException {
    public EntryAlreadyCreated(String message) {
        super(message);
    }
}
