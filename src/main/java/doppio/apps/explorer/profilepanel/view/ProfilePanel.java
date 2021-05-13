package doppio.apps.explorer.profilepanel.view;

import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    ProfilePanelListener profilePanelListener;
    JPanel leftPanel, rightPanel;
    JLabel bigProfileLabel;

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
    }
}
