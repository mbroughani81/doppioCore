package doppio.apps.explorer.profilepanel.view;

import com.google.gson.Gson;
import doppio.apps.authentication.model.User;
import doppio.apps.explorer.explorerpanel.view.ExplorerPanel;
import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;
import doppio.event.AddToFollowerEvent;
import doppio.event.NewSystemNotificationEvent;
import doppio.event.UnfollowEvent;
import doppio.log.AdvancedLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProfilePanel extends JPanel implements AdvancedLog {
    static Logger logger = LogManager.getLogger(ProfilePanel.class);

    ProfilePanelListener profilePanelListener;
    JPanel leftPanel, rightPanel;
    JLabel bigProfileLabel;
    JButton followButton;
    JButton unfollowButton;
    JLabel nameLabel;
    JLabel usernameLabel;
    JLabel timeLabel;
    JLabel followshipLabel;

    public ProfilePanel(ProfilePanelListener profilePanelListener) {
        this.profilePanelListener = profilePanelListener;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("user id", profilePanelListener.getUserId());
        log("ProfilePanel is created", map);

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
//                NewSystemNotificationEvent event1 = new NewSystemNotificationEvent(u1.getId(), "You");
                NewSystemNotificationEvent event2 = new NewSystemNotificationEvent(u2.getId(), "You got followd by " + u1.getUsername());
                profilePanelListener.followUser(event);
                profilePanelListener.newSystemNotification(event2);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(followButton, gbc);

        unfollowButton = new JButton("Unfollow");
        unfollowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User u1 = profilePanelListener.getSessionUser();
                User u2 = profilePanelListener.getProfileUser();
                UnfollowEvent event = new UnfollowEvent(u1, u2);
//                NewSystemNotificationEvent event1 = new NewSystemNotificationEvent(u1.getId(), "You");
                NewSystemNotificationEvent event2 = new NewSystemNotificationEvent(u2.getId(), "You got unfollowd by " + u1.getUsername());
                profilePanelListener.unfollowUser(event);
                profilePanelListener.newSystemNotification(event2);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPanel.add(unfollowButton, gbc);

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

    @Override
    public void log(String message, HashMap<?, ?> map) {
        Gson gson = new Gson();
        logger.trace(message + gson.toJson(map));
    }
}
