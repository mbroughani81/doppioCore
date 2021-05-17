package doppio.apps.explorer.explorerpanel.view;

import doppio.apps.browser.view.BrowserFrame;
import doppio.apps.explorer.explorerpanel.listener.ExplorerPanelListener;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.post.model.Tweet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ExplorerPanel extends JPanel implements TweetClickInvoker, ProfileClickInvoker {
    static Logger logger = LogManager.getLogger(ExplorerPanel.class);

    TweetListPanel tweetListPanel;
    JScrollPane scrollPane;

    TweetClickListener tweetClickListener;
    ProfileClickListener profileClickListener;

    ExplorerPanelListener explorerPanelListener;

    public ExplorerPanel(ExplorerPanelListener explorerPanelListener) {
        logger.trace("ExplorerPanel is created");

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
        tweetListPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        scrollPane.getViewport().add(tweetListPanel);

        LinkedList<Tweet> tweets = explorerPanelListener.getTweets();
        for (Tweet tweet : tweets) {
            tweetListPanel.addTweet(tweet, explorerPanelListener.getSourceTweet(tweet));
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

    @Override
    public void setProfileClickListener(ProfileClickListener listener) {
        this.profileClickListener = listener;
    }

    @Override
    public void checkProfileClickListener(int userId) {
        this.profileClickListener.runProfileClickListener(userId);
    }
}
