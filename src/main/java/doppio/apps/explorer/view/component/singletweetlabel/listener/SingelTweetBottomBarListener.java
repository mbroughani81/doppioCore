package doppio.apps.explorer.view.component.singletweetlabel.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.controller.SessionController;
import doppio.event.NewCommentEvent;
import doppio.event.NewRetweetEvent;

public class SingelTweetBottomBarListener {

    int tweetId;
    AuthController authController;
    PostController postController;
    SessionController sessionController;

    public SingelTweetBottomBarListener(int tweetId) {
        this.tweetId = tweetId;
        authController = new AuthController();
        postController = new PostController();
        sessionController = new SessionController();
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
}
