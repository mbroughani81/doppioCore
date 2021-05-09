package doppio.apps.explorer.showtweets.showsingletweet.view;

import doppio.apps.explorer.showtweets.showsingletweet.listener.ShowSingleTweetPanelListener;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowSingleTweetPanel extends JPanel implements TweetClickInvoker {

    TweetListPanel tweetListPanel;

    ShowSingleTweetPanelListener showSingleTweetPanelListener;

    TweetClickListener tweetClickListener;

    public ShowSingleTweetPanel(ShowSingleTweetPanelListener showSingleTweetPanelListener) {
        this.showSingleTweetPanelListener = showSingleTweetPanelListener;

        this.setLayout(new BorderLayout());

        if (showSingleTweetPanelListener == null) {
            System.out.println("giizez fucking christ showsingletweetpanel const");
        }

        tweetListPanel = new TweetListPanel();
        tweetListPanel.setTweetClickListener(new TweetClickListener() {
            @Override
            public void run(int tweetId) {
                checkTweetClickListener(tweetId);
            }
        });
        this.add(tweetListPanel, BorderLayout.CENTER);

        LinkedList<Tweet> tweets = new LinkedList<>();
        tweets.add(this.showSingleTweetPanelListener.getMainTweet());
        tweets.addAll(this.showSingleTweetPanelListener.getComments());
        for (Tweet tweet : tweets) {
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
        this.tweetClickListener.run(tweetId);
    }
}
