package doppio.apps.explorer.showtweets.showusertweets.view;

import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.tweetlist.listener.TweetClickListener;
import doppio.apps.explorer.tweetlist.view.TweetListPanel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowUserTweetsPanel extends JPanel implements TweetClickInvoker {

    TweetListPanel tweetListPanel;

    private ShowUserTweetPanelListener showUserTweetPanelListener;

    TweetClickListener tweetClickListener;

    public ShowUserTweetsPanel(ShowUserTweetPanelListener listener) {
        this.showUserTweetPanelListener = listener;
        this.setLayout(new BorderLayout());

        tweetListPanel = new TweetListPanel();
        tweetListPanel.setTweetClickListener(new TweetClickListener() {
            @Override
            public void run(int tweetId) {
                checkTweetClickListener(tweetId);
            }
        });
        this.add(tweetListPanel, BorderLayout.CENTER);

        LinkedList<Tweet> tweets = showUserTweetPanelListener.getTweets();
        System.out.println("size is " + tweets.size() + " showusertweetspanel cons");
        for (Tweet tweet : tweets) {
            System.out.println(tweet.getText() + " gg showusertweetspanel");
            tweetListPanel.addTweet(tweet);
        }

        this.tweetClickListener = null;
    }

    @Override
    public void setTweetClickListener(TweetClickListener listener) {
        this.tweetClickListener = listener;
    }

    @Override
    public void checkTweetClickListener(int tweetId) {
        tweetClickListener.run(tweetId);
    }
}
