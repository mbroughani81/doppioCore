package doppio.listener;

import doppio.apps.authentication.exception.InvalidPasswordException;
import doppio.apps.authentication.exception.InvalidUsernameException;
import doppio.event.FormEvent;

public interface FormListener {
    void eventOccurred(FormEvent event) throws InvalidPasswordException, InvalidUsernameException;
}
