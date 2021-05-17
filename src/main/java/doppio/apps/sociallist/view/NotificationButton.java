package doppio.apps.sociallist.view;

import javax.swing.*;
import java.awt.*;

public class NotificationButton extends JButton {
    public NotificationButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 8));
        this.setPreferredSize(new Dimension(50, 20));
    }
}
