package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.explorer.view.component.singletweetlabel.listener.SingelTweetBottomBarListener;
import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SingleTweetLabel extends JLabel implements ProfileClickInvoker {

    JLabel profilePicture;
    JLabel textLabel;
    JPanel bottomBar;

    ProfileClickListener profileClickListener;

    public SingleTweetLabel(Tweet tweet) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(700, 100));

        textLabel = new SingleTweetTextLabel(tweet.getText());
        add(textLabel, BorderLayout.CENTER);

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
        add(bottomBar, BorderLayout.SOUTH);

        profileClickListener = null;
    }

    @Override
    public void setProfileClickInvoker(ProfileClickListener listener) {
        this.profileClickListener = listener;
    }

    @Override
    public void checkProfileClickListener(int userId) {
        this.profileClickListener.runProfileClickListener(userId);
    }
}
