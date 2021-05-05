package doppio.apps.post.view.component;

import javax.swing.*;
import java.awt.*;

public class SendTweetButton extends JButton {

    public SendTweetButton() {
        this.setPreferredSize(new Dimension(200, 30));
        this.setText("Send Tweet");
    }
}
