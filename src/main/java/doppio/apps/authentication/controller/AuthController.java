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

    public User getUser(String username) {
        for (User user : context.Users.all()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public void clearProfileDB() {
        context.Profiles.clear();
    }

    public void clearUserDB() {
        context.Users.clear();
    }
}
