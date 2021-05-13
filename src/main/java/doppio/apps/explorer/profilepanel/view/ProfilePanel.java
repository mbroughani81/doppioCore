package doppio.apps.explorer.profilepanel.view;

import doppio.apps.explorer.profilepanel.listener.ProfilePanelListener;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    ProfilePanelListener profilePanelListener;

    public ProfilePanel(ProfilePanelListener profilePanelListener) {
        this.profilePanelListener = profilePanelListener;

        this.setBackground(Color.RED);
        this.setOpaque(true);
    }
}
