package doppio.apps.post.view.component;

import doppio.config.PostConfig;

import javax.swing.*;
import java.awt.*;

public class SendTweetButton extends JButton {

    PostConfig postConfig = new PostConfig();

    public SendTweetButton() {
        this.setPreferredSize(new Dimension(postConfig.getSendTweetButtonWidth(), postConfig.getSendTweetButtonHeight()));
        this.setText("Send Tweet");
    }
}
