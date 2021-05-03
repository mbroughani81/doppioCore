package doppio.apps.explorer.showtweets.showusertweets.view;

import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.tweetlist.view.TweetListPanel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowUserTweetsPanel extends JPanel {

    TweetListPanel tweetListPanel;

    private ShowUserTweetPanelListener showUserTweetPanelListener;

    public ShowUserTweetsPanel(ShowUserTweetPanelListener listener) {
        this.showUserTweetPanelListener = listener;
        this.setLayout(new BorderLayout());

        tweetListPanel = new TweetListPanel();
        this.add(tweetListPanel, BorderLayout.CENTER);

        LinkedList<Tweet> tweets = showUserTweetPanelListener.getTweets();
        System.out.println("size is " + tweets.size() + " showusertweetspanel cons");
        for (Tweet tweet : tweets) {
            System.out.println(tweet.getText() + " gg showusertweetspanel");
            tweetListPanel.addTweet(tweet);
        }
    }

}
