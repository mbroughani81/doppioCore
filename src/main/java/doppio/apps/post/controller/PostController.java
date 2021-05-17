package doppio.apps.post.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;
import doppio.controller.AbstractController;
import doppio.event.NewCommentEvent;
import doppio.event.NewRetweetEvent;
import doppio.event.NewTweetEvent;

import java.util.LinkedList;

public class PostController extends AbstractController {
    public int newTweet(NewTweetEvent event) {
        Tweet tweet = new Tweet(-1, event.getText(), event.getOwner());
        return context.Tweets.add(tweet);
    }

    public Tweet getTweet(int id) {
        for (Tweet tweet : context.Tweets.all()) {
            if (tweet.getId() == id)
                return tweet;
        }
        return null;
    }

    public LinkedList<Tweet> getAllTweet(int userId) {
        LinkedList<Tweet> tweets = new LinkedList<>();
        for (Tweet tweet : context.Tweets.all()) {
            if (tweet.getCreator().getId() == userId)
                tweets.add(tweet);
        }
        return tweets;
    }

    public LinkedList<Tweet> getAllTweet() {
        return context.Tweets.all();
    }

    public LinkedList<Tweet> getCommentsOfTweet(int tweetId) {
        LinkedList<Tweet> tweets = new LinkedList<>();
        for (Tweet tweet : context.Tweets.all()) {
            if (tweet.getParentTweetId() == tweetId)
                tweets.add(tweet);
        }
        return tweets;
    }

    public void newRetweet(NewRetweetEvent event) {
        Tweet tweet = new Tweet(-1, "this is retweeted", event.getCreator(), event.getOriginalTweet().getId());
        context.Tweets.add(tweet);
    }

    public void newComment(NewCommentEvent event) {
        Tweet tweet = new Tweet(event.getParentTweet().getId(), event.getText(), event.getOwner());
        context.Tweets.add(tweet);
    }

    public void reportSpam(int tweetId) {
        Tweet tweet = context.Tweets.get(tweetId);
        tweet.setSpamCounter(tweet.getSpamCounter() + 1);
        context.Tweets.update(tweet);
    }

    public void clearTweetDB() {
        context.Tweets.clear();
    }

}
