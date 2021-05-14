package doppio.apps.explorer.profilepanel.view;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;
import doppio.event.AddToFollowerEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePanel extends JPanel {

    ProfilePanelListener profilePanelListener;
    JPanel leftPanel, rightPanel;
    JLabel bigProfileLabel;
    JButton followButton;
    JLabel nameLabel;
    JLabel usernameLabel;
    JLabel timeLabel;
    JLabel followshipLabel;

    public ProfilePanel(ProfilePanelListener profilePanelListener) {
        this.profilePanelListener = profilePanelListener;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        leftPanel = new LeftPanel();
        add(leftPanel, BorderLayout.WEST);

        rightPanel = new RightPanel();
        add(rightPanel, BorderLayout.EAST);

        bigProfileLabel = new BigProfileLabel(profilePanelListener.getUserId());
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(bigProfileLabel, gbc);

        followButton = new JButton("Follow");
        followButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User u1 = profilePanelListener.getSessionUser();
                User u2 = profilePanelListener.getProfileUser();
                AddToFollowerEvent event = new AddToFollowerEvent(u1, u2);
                profilePanelListener.followUser(event);
                System.out.println("wierd bruh profilepanel const");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(followButton, gbc);

        nameLabel = new JLabel(profilePanelListener.getProfile().getName());
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(nameLabel, gbc);

        usernameLabel = new JLabel(profilePanelListener.getProfileUser().getUsername());
        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(usernameLabel, gbc);

        timeLabel = new JLabel("last seen in here " + profilePanelListener.getProfile().getPrivacy());
        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(timeLabel, gbc);

        followshipLabel = new JLabel("followship here");
        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(followshipLabel, gbc);
    }
}
