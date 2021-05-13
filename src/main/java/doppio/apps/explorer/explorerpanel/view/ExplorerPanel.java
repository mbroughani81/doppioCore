package doppio.apps.explorer.explorerpanel.view;

import doppio.apps.explorer.explorerpanel.listener.ExplorerPanelListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ExplorerPanel extends JPanel implements TweetClickInvoker {

    TweetListPanel tweetListPanel;
    JScrollPane scrollPane;

    TweetClickListener tweetClickListener;

    ExplorerPanelListener explorerPanelListener;

    public ExplorerPanel(ExplorerPanelListener explorerPanelListener) {
        this.explorerPanelListener = explorerPanelListener;

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
        scrollPane.getViewport().add(tweetListPanel);

        LinkedList<Tweet> tweets = explorerPanelListener.getTweets();
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
