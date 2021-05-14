package doppio.apps.explorer.showtweets.showusertweets.listener;

import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.controller.SessionController;

import java.util.LinkedList;

public class ShowUserTweetPanelListener {
    PostController postController;
    SessionController sessionController;

    public ShowUserTweetPanelListener() {
        postController = new PostController();
        sessionController = new SessionController();
    }

    public int getUserId() {
        return sessionController.getSession(0).getUserId();
    }

    public LinkedList<Tweet> getTweets() {
        LinkedList<Tweet> tweets = new LinkedList<>();
        int userId = sessionController.getSession(0).getUserId();
        tweets = postController.getAllTweet(userId);
        System.out.println("getTweets showusertweetpanellistener");
        for (Tweet tweet : tweets)
            System.out.println(tweet.getText());
//        sessionController
        return tweets;
    }
}
