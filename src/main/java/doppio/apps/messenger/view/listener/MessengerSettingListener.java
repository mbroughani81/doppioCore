package doppio.apps.messenger.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class MessengerSettingListener {
    AuthController authController;
    SessionController sessionController;
    SocialListController socialListController;

    public MessengerSettingListener() {
        authController = new AuthController();
        sessionController = new SessionController();
        socialListController = new SocialListController();
    }

    public User getUser(int userId) {
        return authController.getUser(userId);
    }

    public LinkedList<Integer> getFollowingIds() {
        int userId = sessionController.getSession(0).getUserId();
        User u = authController.getUser(userId);
        return socialListController.getFollowingList(u).getList();
    }
}
