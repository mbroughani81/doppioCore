package doppio.apps.messenger.view;

import doppio.apps.messenger.model.GroupChat;
import doppio.apps.messenger.model.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    public ChatLabel(PrivateChat privateChat) {
        this.setPreferredSize(new Dimension(500, 30));
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.setText(privateChat.getUser1id() + " to " + privateChat.getUser2id());
    }

    public ChatLabel(GroupChat groupChat) {

    }
}
