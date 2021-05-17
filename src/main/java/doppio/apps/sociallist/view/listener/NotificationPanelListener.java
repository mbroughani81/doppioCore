package doppio.apps.sociallist.view.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.sociallist.model.FollowRequestNotification;
import doppio.apps.sociallist.model.SystemNotification;
import doppio.controller.SessionController;
import doppio.event.AddToFollowerEvent;
import doppio.event.NewSystemNotificationEvent;

import java.util.LinkedList;

public class NotificationPanelListener {

    SocialListController socialListController = new SocialListController();
    SessionController sessionController = new SessionController();
    AuthController authController = new AuthController();

    public LinkedList<FollowRequestNotification> getUserRequests(int userId) {
        return socialListController.getUserRequests(userId);
    }

    public LinkedList<FollowRequestNotification> getUserRequestInbox() {
        int userId = sessionController.getSession(0).getUserId();
        return socialListController.getUserRequestInbox(userId);
    }

    public LinkedList<SystemNotification> getUserSystemNotifications() {
        int userId = sessionController.getSession(0).getUserId();
        return socialListController.getUserSystemNotifications(userId);
    }

    public void acceptRequestNotification(FollowRequestNotification notification) {
        socialListController.deleteRequestNotification(notification);
        User u1 = authController.getUser(notification.getFollowerId());
        User u2 = authController.getUser(notification.getFollowingId());
        AddToFollowerEvent event = new AddToFollowerEvent(u1, u2);
        socialListController.addToFollower(event);
        NewSystemNotificationEvent event1 = new NewSystemNotificationEvent(
                notification.getFollowingId(),
                notification.getFollowerId() + " started following you"
        );
        NewSystemNotificationEvent event2 = new NewSystemNotificationEvent(
                notification.getFollowerId(),
                notification.getFollowingId() + " accepted your request"
        );
        socialListController.addSystemNotification(event1);
        socialListController.addSystemNotification(event2);
    }
    public void declineRequestNotification(FollowRequestNotification notification) {
        socialListController.deleteRequestNotification(notification);
        NewSystemNotificationEvent event1 = new NewSystemNotificationEvent(
                notification.getFollowerId(),
                notification.getFollowingId() + " declined your request"
        );
        socialListController.addSystemNotification(event1);
    }
    public void silentDeclineRequestNotification(FollowRequestNotification notification) {
        socialListController.deleteRequestNotification(notification);
    }
}
