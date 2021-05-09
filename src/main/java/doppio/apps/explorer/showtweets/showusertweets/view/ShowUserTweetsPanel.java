package doppio.apps.explorer.showtweets.showusertweets.view;

import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowUserTweetsPanel extends JPanel implements TweetClickInvoker {

    TweetListPanel tweetListPanel;
    JScrollPane scrollPane;

    private ShowUserTweetPanelListener showUserTweetPanelListener;

    TweetClickListener tweetClickListener;

    public ShowUserTweetsPanel(ShowUserTweetPanelListener listener) {
        this.showUserTweetPanelListener = listener;
        this.setLayout(new BorderLayout());

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane, BorderLayout.CENTER);

        tweetListPanel = new TweetListPanel();
        tweetListPanel.setTweetClickListener(new TweetClickListener() {
            @Override
            public void run(int tweetId) {
                checkTweetClickListener(tweetId);
            }
        });
//        tweetListPanel.setPreferredSize(new Dimension(400, 1000));
//        JLabel label = new JLabel();
//        label.setBackground(Color.CYAN); label.setOpaque(true);
//        label.setSize(10, 10);
//        scrollPane.getViewport().add(label);
//        this.add(tweetListPanel, BorderLayout.CENTER);
        scrollPane.getViewport().add(tweetListPanel);

        LinkedList<Tweet> tweets = showUserTweetPanelListener.getTweets();
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
        tweetClickListener.run(tweetId);
    }
}
