package doppio.apps.sociallist.view;

import doppio.apps.sociallist.view.listener.NotificationLabelListener;

import javax.swing.*;
import java.awt.*;

public class InboxRequestLabel extends JLabel {

    NotificationLabelListener listener;
    JPanel buttonHolder;
    JButton acceptButton;
    JButton normalDeclineButton;
    JButton silentDeclineButton;

    public InboxRequestLabel(String text, NotificationLabelListener listener) {
        this.listener = listener;

        this.setPreferredSize(new Dimension(400, 50));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.PINK);
        this.setOpaque(true);
        this.setText(text);

        buttonHolder = new ButtonHolder();
        add(buttonHolder, BorderLayout.EAST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHEAST;
//
        acceptButton = new NotificationButton("YES");
//        acceptButton.set
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonHolder.add(acceptButton, gbc);
        normalDeclineButton = new NotificationButton("NO");
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonHolder.add(normalDeclineButton, gbc);
        silentDeclineButton = new NotificationButton("no");
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonHolder.add(silentDeclineButton, gbc);
    }
}
