package doppio.apps.explorer.view.component.singletweetlabel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.model.ChatType;
import doppio.apps.messenger.model.UserType;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.timeline.controller.TimelineController;
import doppio.controller.SessionController;
import doppio.event.*;

import java.util.LinkedList;

public class SingelTweetBottomBarListener {

    int tweetId;
    AuthController authController = new AuthController();
    PmController pmController = new PmController();
    PostController postController = new PostController();
    SessionController sessionController = new SessionController();
    TimelineController timelineController = new TimelineController();
    MessageController messageController = new MessageController();
    SocialListController socialListController = new SocialListController();

    public SingelTweetBottomBarListener(int tweetId) {
        this.tweetId = tweetId;
    }

    public void newComment(NewCommentEvent event) {
        postController.newComment(event);
    }

    public User getUser() {
        int userId = sessionController.getSession(0).getUserId();
        return authController.getUser(userId);
    }
    public User getUser(int userId) {
        return authController.getUser(userId);
    }


    public Tweet getTweet() {
        return postController.getTweet(tweetId);
    }

    public void newRetweet(NewRetweetEvent event) {
        postController.newRetweet(event);
    }

    public void addLike(NewLikeEvent event) {
        timelineController.newLike(event);
    }

    public void reportSpam() {
        System.out.println("tweet id is " + tweetId + " singletweetbpttp,bar;ostemer");
        postController.reportSpam(tweetId);
    }

    public void blockUser() {
        User u1 = authController.getUser(sessionController.getSession(0).getUserId());
        User u2 = authController.getUser(postController.getTweet(tweetId).getCreator().getId());
        AddToBlockedEvent event = new AddToBlockedEvent(u1, u2);
        socialListController.addToBlocked(event);

    }

    public void muteUser() {
        User u1 = authController.getUser(sessionController.getSession(0).getUserId());
        User u2 = authController.getUser(postController.getTweet(tweetId).getCreator().getId());
        AddToMutedEvent event = new AddToMutedEvent(u1.getId(), u2.getId());
        timelineController.addToMuted(event);
    }
    public void newPm(NewPmEvent event) {
        pmController.sendNewPm(event);
    }

    public int getChatId(int userId) {
        int userId1 = sessionController.getSession(0).getUserId();
        int userId2 = userId;
        for (Chat chat : messageController.getPrivateChats(userId1)) {
            if (chat.getChatType() == ChatType.PRIVATE && chat.getMemberIds().contains(userId2))
                return chat.getId();
        }
        NewPrivateChatEvent event = new NewPrivateChatEvent(userId1, userId2);
        return messageController.newPrivateChat(event);
    }

    public LinkedList<UserType> getTypes() {
        int userId = sessionController.getSession(0).getUserId();
        LinkedList<UserType> res = new LinkedList<>();
        for (UserType userType : messageController.getAllUserTypes()) {
            if (userType.getOwnerId() == userId)
                res.add(userType);
        }
        return res;
    }
    public UserType getUserType(int userTypeId) {
        for (UserType userType : messageController.getAllUserTypes()) {
            if (userType.getId() == userTypeId)
                return userType;
        }
        return null;
    }
    public LinkedList<Integer> getFollowingIds() {
        int userId = sessionController.getSession(0).getUserId();
        User u = authController.getUser(userId);
        return socialListController.getFollowingList(u).getList();
    }

    public void sendPmToSavedMessage(String text) {
        int userId = sessionController.getSession(0).getUserId();
        for (Chat chat : messageController.getPrivateChats(userId)) {
            if (chat.getMemberIds().size() == 1) {
                NewPmEvent event = new NewPmEvent(userId, chat.getId(), text);
                pmController.sendNewPm(event);
                return;
            }
        }
    }
}
