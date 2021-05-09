package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.post.model.Tweet;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class SingleTweetLabel extends JLabel {

    JLabel textLabel;
    JPanel bottomBar;

    public SingleTweetLabel(Tweet tweet) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(700, 100));

        textLabel = new SingleTweetTextLabel(tweet.getText());
        add(textLabel, BorderLayout.CENTER);

        bottomBar = new SingleTweetBottomBar();
        add(bottomBar, BorderLayout.SOUTH);
    }
}
