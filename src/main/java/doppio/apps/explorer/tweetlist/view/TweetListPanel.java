package doppio.apps.explorer.tweetlist.view;

import doppio.apps.explorer.view.SingleTweetLabel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class TweetListPanel extends JPanel {

    LinkedList<Tweet> tweets;

    public TweetListPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);

        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
        GridBagConstraints gbc = new GridBagConstraints();

        this.removeAll();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Tweet tweet1 : tweets) {
            SingleTweetLabel label = new SingleTweetLabel(tweet1);
            this.add(label, gbc);
            gbc.gridy++;
        }

        this.repaint();
        this.revalidate();
    }
}
