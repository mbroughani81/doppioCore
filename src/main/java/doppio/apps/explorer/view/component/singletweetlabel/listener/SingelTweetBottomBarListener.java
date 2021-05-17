package doppio.apps.explorer.view.component.singletweetlabel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.apps.timeline.controller.TimelineController;
import doppio.controller.SessionController;
import doppio.event.*;

public class SingelTweetBottomBarListener {

    int tweetId;
    AuthController authController = new AuthController();
    PostController postController = new PostController();
    SessionController sessionController = new SessionController();
    TimelineController timelineController = new TimelineController();
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
}
