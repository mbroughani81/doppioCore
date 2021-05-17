package doppio.apps.explorer.view.component.singletweetlabel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.apps.timeline.controller.TimelineController;
import doppio.controller.SessionController;
import doppio.event.NewCommentEvent;
import doppio.event.NewLikeEvent;
import doppio.event.NewRetweetEvent;

public class SingelTweetBottomBarListener {

    int tweetId;
    AuthController authController = new AuthController();
    PostController postController = new PostController();
    SessionController sessionController = new SessionController();
    TimelineController timelineController = new TimelineController();

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
}
