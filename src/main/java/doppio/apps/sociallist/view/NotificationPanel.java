package doppio.apps.sociallist.view;

import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {
    static Logger logger = LogManager.getLogger(NotificationPanel.class);

    public NotificationPanel() {
        logger.trace("NotificationPanel is created");

        this.setBackground(Color.GREEN);
        this.setOpaque(true);
    }
}
