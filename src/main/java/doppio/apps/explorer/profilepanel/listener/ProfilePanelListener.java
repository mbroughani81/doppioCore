package doppio.apps.explorer.profilepanel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.LastSeenPrivacy;
import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.sociallist.model.FollowingList;
import doppio.controller.SessionController;
import doppio.event.AddToFollowerEvent;
import doppio.event.NewFollowRequestEvent;
import doppio.event.NewSystemNotificationEvent;
import doppio.event.UnfollowEvent;

import java.time.LocalDateTime;

public class ProfilePanelListener {

    int userId;

    AuthController authController = new AuthController();
    SessionController sessionController = new SessionController();
    SocialListController socialListController = new SocialListController();

    public ProfilePanelListener(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public User getSessionUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }

    public Profile getProfile() {
        User user = authController.getUser(userId);
        return authController.getProfile(user.getProfile().getId());
    }

    public User getProfileUser() {
        return authController.getUser(this.userId);
    }

    public void followUser(AddToFollowerEvent event) {
        Profile followedProfile = authController.getProfile(event.getFollowd().getProfile().getId());
        // if blocked return null;
        if (followedProfile.getPrivacy() == Privacy.PUBLIC) {
            socialListController.addToFollower(event);
            NewSystemNotificationEvent event2 = new NewSystemNotificationEvent(
                    event.getFollowd().getId(),
                    "You got followd by " + event.getFollower().getUsername()
            );
            socialListController.addSystemNotification(event2);
        }
        if (followedProfile.getPrivacy() == Privacy.PRIVATE) {
            NewFollowRequestEvent event1 = new NewFollowRequestEvent(event.getFollower(), event.getFollowd());
            socialListController.sentRequest(event1);
        }
    }

    public void unfollowUser(UnfollowEvent event) {
        socialListController.unfollow(event);
    }

    public void newSystemNotification(NewSystemNotificationEvent event) {
        socialListController.addSystemNotification(event);
    }

    public String getLastSeen() {
        User user = authController.getUser(userId);
        Profile profile = authController.getProfile(user.getProfile().getId());
        FollowingList followingList = socialListController.getFollowingList(user);
        int id = sessionController.getSession(0).getUserId();
        if (profile.getLastSeenPrivacy() == LastSeenPrivacy.NOBODY ||
                (profile.getLastSeenPrivacy() == LastSeenPrivacy.FOLLOWING && !followingList.getList().contains(id)))
            return " recently";
        LocalDateTime time = profile.getLastSeen();
        return time.getHour() + " : " + time.getMinute();
    }
}
