package doppio.apps.explorer.view.component.tweetlist;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickInvoker;
import doppio.apps.explorer.view.component.tweetlist.listener.TweetClickListener;
import doppio.apps.explorer.view.component.singletweetlabel.SingleTweetLabel;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class TweetListPanel extends JPanel implements TweetClickInvoker, ProfileClickInvoker {

    LinkedList<Tweet> tweets;

    TweetClickListener tweetClickListener;
    ProfileClickListener profileClickListener;

    public TweetListPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);

        tweets = new LinkedList<>();
        tweetClickListener = null;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
        this.setPreferredSize(new Dimension(0, 100 * tweets.size()));

        GridBagConstraints gbc = new GridBagConstraints();

        this.removeAll();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Tweet tweet1 : tweets) {
            TweetClickAction tweetClickAction = new TweetClickAction(tweet1);
            SingleTweetLabel label = new SingleTweetLabel(tweet1);
            label.setProfileClickListener(new ProfileClickListener() {
                @Override
                public void runProfileClickListener(int userId) {
                    checkProfileClickListener(userId);
                }
            });
            label.addMouseListener(tweetClickAction);
            this.add(label, gbc);
            gbc.gridy++;
        }

        this.repaint();
        this.revalidate();
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

    class TweetClickAction implements MouseListener {

        Tweet tweet;

        public TweetClickAction(Tweet tweet) {
            this.tweet = tweet;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) { ;
            System.out.println("tweet is clicked tweetclickaction tweetlistpanel");
            checkTweetClickListener(tweet.getId());
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
