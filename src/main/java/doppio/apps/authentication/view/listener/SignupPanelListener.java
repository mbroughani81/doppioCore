package doppio.apps.authentication.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.exception.DuplicateFieldException;
import doppio.apps.authentication.exception.EmptyFieldException;
import doppio.event.NewUserEvent;

public class SignupPanelListener {
    AuthController authController = new AuthController();

    public void newUser(NewUserEvent event) throws EmptyFieldException, DuplicateFieldException {
        if (event.getName().isEmpty() || event.getUsername().isEmpty() || event.getPassword().isEmpty() || event.getEmail().isEmpty())
            throw new EmptyFieldException("name username password email field can not be empty");
        if (authController.usernameExists(event.getUsername()))
            throw new DuplicateFieldException("Username already taken");
        if (authController.emailExists(event.getEmail()))
            throw new DuplicateFieldException("Email already taken");
        if (authController.phonenumberExists(event.getPhoneNumber()))
            throw new DuplicateFieldException("Phonenumber already taken");
        authController.addUser(event);
    }
}
