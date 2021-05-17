package doppio.apps.timeline.view;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.post.model.Tweet;
import doppio.apps.timeline.view.listener.TimelinePanelListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class TimelinePanel extends JPanel implements TweetClickInvoker, ProfileClickInvoker {
    static Logger logger = LogManager.getLogger(TimelinePanel.class);

    TweetListPanel tweetListPanel;
    JScrollPane scrollPane;

    TweetClickListener tweetClickListener;
    ProfileClickListener profileClickListener;

    TimelinePanelListener timelinePanelListener;

    public TimelinePanel(TimelinePanelListener timelinePanelListener) {
        logger.trace("TimelinePanel is created");

        this.timelinePanelListener = timelinePanelListener;

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

        LinkedList<Tweet> tweets = timelinePanelListener.getTweets();
        for (Tweet tweet : tweets) {
            tweetListPanel.addTweet(tweet, timelinePanelListener.getSourceTweet(tweet));
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
