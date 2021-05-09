package doppio.apps.explorer.view.component.singletweetlabel;

import javax.swing.*;
import java.awt.*;

public class SingleTweetBottomBar extends JPanel {

    JButton likeButton;
    JButton retweetButton;
    JButton commentButton;
    JButton otherButton;

    public SingleTweetBottomBar() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(0, 40));
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        commentButton = new CommentButton();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(commentButton, gbc);
        retweetButton = new RetweetButton();
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(retweetButton, gbc);
        likeButton = new LikeButton();
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(likeButton, gbc);
        otherButton = new OtherButton();
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(otherButton, gbc);
    }
}
