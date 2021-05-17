package doppio.apps.post.controller;

import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.timeline.model.MutedUserList;
import doppio.apps.timeline.model.ReportedTweetList;
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


    public LinkedList<Tweet> getPublicTweet() {
        User userr = context.Users.get(context.Sessions.get(0).getUserId());
        MutedUserList mutedUserList = context.MutedUserLists.get(userr.getMutedUserListId());
        BlockList blockList = context.Blocklists.get(userr.getBlockListId());

        LinkedList<Tweet> tweets = new LinkedList<>();
        for (Tweet tweet : context.Tweets.all()) {
            User user = context.Users.get(tweet.getCreator().getId());
            Profile profile = context.Profiles.get(user.getProfile().getId());
            if (
                    profile.getPrivacy() == Privacy.PUBLIC &&
                    !mutedUserList.getUserIds().contains(user.getId()) &&
                    !blockList.getList().contains(user.getMutedUserListId()) &&
                    tweet.getSpamCounter() < 3
            ) {
                tweets.add(tweet);
            }
        }
        return tweets;
    }

    public LinkedList<Tweet> getTimelineTweet() {
        User userr = context.Users.get(context.Sessions.get(0).getUserId());
        MutedUserList mutedUserList = context.MutedUserLists.get(userr.getMutedUserListId());
        BlockList blockList = context.Blocklists.get(userr.getBlockListId());
        LinkedList<Integer> goodTweets = new LinkedList<>();
        for (int userId : context.FollowingLists.get(userr.getFollowingListId()).getList()) {
            User u = context.Users.get(userId);
            goodTweets.addAll(context.LikedTweetLists.get(u.getLikedTweetListId()).getTweetIds());
            for (Tweet t : getAllTweet(u.getId()))
                goodTweets.add(t.getId());
        }

        LinkedList<Tweet> tweets = new LinkedList<>();
        for (Tweet tweet : context.Tweets.all()) {
            User user = context.Users.get(tweet.getCreator().getId());
            Profile profile = context.Profiles.get(user.getProfile().getId());
            if (!mutedUserList.getUserIds().contains(user.getId()) &&
                    !blockList.getList().contains(user.getMutedUserListId()) &&
                    tweet.getSpamCounter() < 3 &&
                    goodTweets.contains(tweet.getId())
            ) {
                tweets.add(tweet);
            }
        }
        return tweets;
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
        User user = context.Users.get(context.Sessions.get(0).getUserId());
        ReportedTweetList reportedTweetList = context.ReportedTweetLists.get(user.getReportedTweetListId());
        if (reportedTweetList.getTweetIds().contains(tweetId))
            return;
        Tweet tweet = context.Tweets.get(tweetId);
        tweet.setSpamCounter(tweet.getSpamCounter() + 1);
        context.Tweets.update(tweet);
        reportedTweetList.getTweetIds().add(tweetId);
        context.ReportedTweetLists.update(reportedTweetList);
    }

    public void clearTweetDB() {
        context.Tweets.clear();
    }

}
