package doppio.apps.explorer.showtweets.showusertweets.view;

import com.google.gson.Gson;
import doppio.apps.explorer.showtweets.showsingletweet.view.ShowSingleTweetPanel;
import doppio.apps.explorer.showtweets.showusertweets.listener.ShowUserTweetPanelListener;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.explorer.view.component.tweetlist.TweetListPanel;
import doppio.apps.post.model.Tweet;
import doppio.log.AdvancedLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ShowUserTweetsPanel extends JPanel implements TweetClickInvoker, ProfileClickInvoker, AdvancedLog {
    static Logger logger = LogManager.getLogger(ShowUserTweetsPanel.class);

    TweetListPanel tweetListPanel;
    JScrollPane scrollPane;

    private ShowUserTweetPanelListener showUserTweetPanelListener;

    TweetClickListener tweetClickListener;
    ProfileClickListener profileClickListener;

    public ShowUserTweetsPanel(ShowUserTweetPanelListener listener) {
        this.showUserTweetPanelListener = listener;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("user id", showUserTweetPanelListener.getUserId());
        log("ShowUserTweetsPanel is created", map);

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

        LinkedList<Tweet> tweets = showUserTweetPanelListener.getTweets();
        for (Tweet tweet : tweets) {
            tweetListPanel.addTweet(tweet, showUserTweetPanelListener.getSourceTweet(tweet));
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

    @Override
    public void log(String message, HashMap<?, ?> map) {
        Gson gson = new Gson();
        logger.trace(message + gson.toJson(map));
    }
}
