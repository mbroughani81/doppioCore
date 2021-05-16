package doppio.apps.sociallist.view;

import doppio.apps.sociallist.model.SystemNotification;
import doppio.apps.sociallist.view.eventitemlist.NotificationItemList;
import doppio.apps.sociallist.view.listener.NotificationPanelListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {
    static Logger logger = LogManager.getLogger(NotificationPanel.class);

    JPanel requestNotificationsPanel;
    JPanel systemNotificationsPanel;
    NotificationItemList requestNotificationsList;
    NotificationItemList systemNotificationsList;

    NotificationPanelListener notificationPanelListener;

    public NotificationPanel(NotificationPanelListener notificationPanelListener) {
        logger.trace("NotificationPanel is created");

        this.notificationPanelListener = notificationPanelListener;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        requestNotificationsPanel = new LeftPanel();
        requestNotificationsList = new NotificationItemList();
        requestNotificationsPanel.add(requestNotificationsList, BorderLayout.CENTER);
        add(requestNotificationsPanel, BorderLayout.WEST);

        systemNotificationsPanel = new RightPanel();
        systemNotificationsList = new NotificationItemList();
        for (SystemNotification systemNotification : notificationPanelListener.getUserSystemNotifications()) {
            systemNotificationsList.addSystemNotification(systemNotification.getText());
        }
        systemNotificationsPanel.add(systemNotificationsList, BorderLayout.CENTER);
        add(systemNotificationsPanel, BorderLayout.EAST);
    }
}
