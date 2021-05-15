package doppio.apps.messenger.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.messenger.controller.MessageController;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.controller.SessionController;
import doppio.event.NewGroupChatEvent;
import doppio.event.NewUserTypeEvent;

import java.util.LinkedList;

public class MessengerSettingListener {
    AuthController authController;
    SessionController sessionController;
    SocialListController socialListController;
    MessageController messageController;

    public MessengerSettingListener() {
        authController = new AuthController();
        sessionController = new SessionController();
        socialListController = new SocialListController();
        messageController = new MessageController();
    }

    public User getUser(int userId) {
        return authController.getUser(userId);
    }

    public User getUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }

    public LinkedList<Integer> getFollowingIds() {
        int userId = sessionController.getSession(0).getUserId();
        User u = authController.getUser(userId);
        return socialListController.getFollowingList(u).getList();
    }

    public void newUserType(NewUserTypeEvent event) {
        messageController.newUserType(event);
    }

    public void newGroupChat(NewGroupChatEvent event) {
        messageController.newGroupChat(event);
    }
}
