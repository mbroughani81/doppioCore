package doppio.apps.messenger.view.component;

import doppio.apps.messenger.model.Chat;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    public ChatLabel(Chat chat) {
        this.setPreferredSize(new Dimension(500, 30));
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.setText(chat.getChatName() + " : owner -> " + chat.getOwnerId() + "  members -> " + chat.getMemberIds());
    }
}
