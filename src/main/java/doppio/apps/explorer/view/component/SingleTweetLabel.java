package doppio.apps.explorer.view.component;

import doppio.apps.post.model.Tweet;

import javax.swing.*;
import java.awt.*;

public class SingleTweetLabel extends JLabel {

    public SingleTweetLabel(Tweet tweet) {
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setText(tweet.getText());
        this.setPreferredSize(new Dimension(400, 30));
    }
}
