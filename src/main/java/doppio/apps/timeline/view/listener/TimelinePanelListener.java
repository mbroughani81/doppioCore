package doppio.apps.timeline.view.listener;

import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;

import java.util.LinkedList;

public class TimelinePanelListener {

    PostController postController = new PostController();

    public LinkedList<Tweet> getTweets() {
        return postController.getTimelineTweet();
    }

    public Tweet getSourceTweet(Tweet tweet) {
        if (tweet.getSourceId() == -1)
            return null;
        return postController.getTweet(tweet.getSourceId());
    }
}
