package VascoPanigi.exceptions;

import java.util.UUID;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(UUID id) {
        super("The event with id " + id + " isn't in our database!");
    }

}
