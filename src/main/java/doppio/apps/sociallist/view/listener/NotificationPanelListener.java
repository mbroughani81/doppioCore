package doppio.apps.sociallist.view.listener;

import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.sociallist.model.FollowRequestNotification;
import doppio.apps.sociallist.model.SystemNotification;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class NotificationPanelListener {

    SocialListController socialListController = new SocialListController();
    SessionController sessionController = new SessionController();

    public LinkedList<FollowRequestNotification> getUserRequests(int userId) {
        return socialListController.getUserRequests(userId);
    }

    public LinkedList<FollowRequestNotification> getUserRequestInbox(int userId) {
        return socialListController.getUserRequestInbox(userId);
    }

    public LinkedList<SystemNotification> getUserSystemNotifications() {
        int userId = sessionController.getSession(0).getUserId();
        return socialListController.getUserSystemNotifications(userId);
    }
}
