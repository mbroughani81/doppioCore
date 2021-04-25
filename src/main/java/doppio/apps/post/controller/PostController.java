package doppio.apps.post.controller;

import doppio.apps.post.model.Tweet;
import doppio.controller.AbstractController;
import doppio.event.NewCommentEvent;
import doppio.event.NewRetweetEvent;
import doppio.event.NewTweetEvent;

public class PostController extends AbstractController {
    public void newTweet(NewTweetEvent event) {
        Tweet tweet = new Tweet(-1, event.getText(), event.getOwner());
        context.Tweets.add(tweet);
    }

    public Tweet getTweet(int id) {
        for (Tweet tweet : context.Tweets.all()) {
            if (tweet.getId() == id)
                return tweet;
        }
        return null;
    }

    public void newRetweet(NewRetweetEvent event) {
        Tweet tweet = new Tweet(-1, "this is retweeted", event.getCreator(), event.getOriginalTweet().getId());
        context.Tweets.add(tweet);
    }

    public void newComment(NewCommentEvent event) {
        Tweet tweet = new Tweet(event.getParentTweet().getId(), event.getText(), event.getOwner());
        context.Tweets.add(tweet);
    }

    public void clearTweetDB() {
        context.Tweets.clear();
    }

}
