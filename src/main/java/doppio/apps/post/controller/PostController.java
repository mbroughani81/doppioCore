package doppio.apps.post.controller;

import doppio.apps.post.model.Tweet;
import doppio.controller.AbstractController;
import doppio.event.NewTweetEvent;

public class PostController extends AbstractController {
    public void newTweet(NewTweetEvent event) {
        Tweet tweet = new Tweet(null, event.getText(), event.getOwner(), event.getOwner());
        context.Tweets.add(tweet);
    }
}
