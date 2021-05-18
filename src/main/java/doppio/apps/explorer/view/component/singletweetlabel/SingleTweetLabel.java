package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.singletweetlabel.listener.SingelTweetBottomBarListener;
import doppio.apps.post.model.Tweet;
import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SingleTweetLabel extends JLabel implements ProfileClickInvoker {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    JLabel profilePicture;
    TweetContentPanel tweetContentPanel;
    JLabel textLabel;
    JLabel tweetImage;
    JPanel bottomBar;

    ProfileClickListener profileClickListener;

    public SingleTweetLabel(Tweet tweet) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(explorerConfig.getSingleTweetLabelWidth(), explorerConfig.getSingleTweetLabelHeight()));

        textLabel = new SingleTweetTextLabel(tweet.getText());
        tweetImage = new SingleTweetImageLabel(tweet.getId());

        tweetContentPanel = new TweetContentPanel();
        tweetContentPanel.addPreferredSize(textLabel);
        tweetContentPanel.addPreferredSize(tweetImage);
        tweetContentPanel.add(textLabel, BorderLayout.CENTER);
        tweetContentPanel.add(tweetImage, BorderLayout.SOUTH);

        addPreferredSize(tweetContentPanel);
        add(tweetContentPanel, BorderLayout.CENTER);

        profilePicture = new ProfilePictureLabel(tweet.getCreator().getId());
        profilePicture.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                checkProfileClickListener(tweet.getCreator().getId());
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
        });
        add(profilePicture, BorderLayout.WEST);

        bottomBar = new SingleTweetBottomBar(new SingelTweetBottomBarListener(tweet.getId()));
        addPreferredSize(bottomBar);
        add(bottomBar, BorderLayout.SOUTH);

        profileClickListener = null;
    }

    private void addPreferredSize(JComponent component) {
        this.setPreferredSize(new Dimension(
                (int)getPreferredSize().getWidth(),
                (int)getPreferredSize().getHeight() + (int)component.getPreferredSize().getHeight()
        ));
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
