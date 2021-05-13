package doppio.apps.personalpage.showlist.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class ShowListPanelListener {

    AuthController authController;
    SessionController sessionController;
    SocialListController socialListController;

    public ShowListPanelListener() {
        authController = new AuthController();
        sessionController = new SessionController();
        socialListController = new SocialListController();
    }

    public LinkedList<User> getFollowing() {
        int userId = sessionController.getSession(0).getUserId();
        User user = authController.getUser(userId);
        FollowingList followingList = socialListController.getFollowingList(user);
        LinkedList<User> res = new LinkedList<>();
        for (int id : followingList.getList()) {
            res.add(authController.getUser(id));
        }
        return res;
    }

    public LinkedList<User> getFollowers() {
        int userId = sessionController.getSession(0).getUserId();
        User user = authController.getUser(userId);
        FollowerList followerList = socialListController.getFollowersList(user);
        LinkedList<User> res = new LinkedList<>();
        for (int id : followerList.getList()) {
            res.add(authController.getUser(id));
        }
        return res;
    }

    public LinkedList<User> getBlocked() {
        int userId = sessionController.getSession(0).getUserId();
        User user = authController.getUser(userId);
        BlockList blockList = socialListController.getBlocked(user);
        LinkedList<User> res = new LinkedList<>();
        for (int id : blockList.getList()) {
            res.add(authController.getUser(id));
        }
        return res;
    }
}
