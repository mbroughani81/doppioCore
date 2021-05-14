package doppio.apps.explorer.showtweets.showsingletweet.listener;

import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;

import java.util.LinkedList;

public class ShowSingleTweetPanelListener {
    int tweetId;
    PostController postController;

    public ShowSingleTweetPanelListener(int tweetId) {
        this.tweetId = tweetId;

        postController = new PostController();
    }

    public int getTweetId() {
        return tweetId;
    }

    public Tweet getMainTweet() {
        return postController.getTweet(tweetId);
    }

    public LinkedList<Tweet> getComments() {
        return postController.getCommentsOfTweet(tweetId);
    }

}
