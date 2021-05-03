package doppio.apps.explorer.showtweets.showusertweets.view;

import doppio.apps.explorer.tweetlist.view.TweetListPanel;

import javax.swing.*;
import java.awt.*;

public class ShowUserTweetsPanel extends JPanel {

    TweetListPanel tweetListPanel;

    public ShowUserTweetsPanel() {
        this.setLayout(new BorderLayout());

        tweetListPanel = new TweetListPanel();
        this.add(tweetListPanel, BorderLayout.CENTER);

    }
}
