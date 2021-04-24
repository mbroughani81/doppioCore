package doppio.apps.authentication.controller;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.controller.AbstractController;
import doppio.event.NewUserEvent;

public class AuthController extends AbstractController {

    public void addUser(NewUserEvent event) {
        Profile profile = new Profile(event.getName(), event.getBirthday(), event.getEmail(), event.getPhoneNumber(), event.getBio());
        User user = new User(profile, event.getUsername(), event.getPassword());
        context.Profiles.add(profile);
        context.Users.add(user);
    }
}
