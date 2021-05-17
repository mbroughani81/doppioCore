package doppio.apps.sociallist.view;

import doppio.apps.sociallist.view.listener.NotificationLabelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InboxRequestLabel extends JLabel implements ActionListener {

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
        acceptButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonHolder.add(acceptButton, gbc);
        normalDeclineButton = new NotificationButton("NO");
        normalDeclineButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonHolder.add(normalDeclineButton, gbc);
        silentDeclineButton = new NotificationButton("no");
        silentDeclineButton.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonHolder.add(silentDeclineButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton) {
            listener.run(0);
        }
        if (e.getSource() == normalDeclineButton) {
            listener.run(1);
        }
        if (e.getSource() == silentDeclineButton) {
            listener.run(2);
        }
    }
}
