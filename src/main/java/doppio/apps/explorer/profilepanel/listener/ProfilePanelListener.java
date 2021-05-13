package doppio.apps.explorer.profilepanel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.controller.SessionController;
import doppio.event.AddToFollowerEvent;

public class ProfilePanelListener {

    int userId;

    AuthController authController;
    SessionController sessionController;
    SocialListController socialListController;

    public ProfilePanelListener(int userId) {
        this.userId = userId;

        authController = new AuthController();
        sessionController = new SessionController();
        socialListController = new SocialListController();
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }

    public User getProfileUser() {
        return authController.getUser(this.userId);
    }

    public void followUser(AddToFollowerEvent event) {
        socialListController.addToFollower(event);
    }
}
