package doppio.apps.browser.view;

import javax.swing.*;
import java.awt.*;

public class AppsMenuPanel extends JPanel {

    JButton personalPageAppButton;
    JButton timelineAppButton;
    JButton explorerAppButton;
    JButton messengerAppButton;
    JButton settingAppButton;

    public AppsMenuPanel() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(200, 0));
        this.setBackground(Color.ORANGE);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        this.personalPageAppButton = new JButton("PersonalPage");
        this.timelineAppButton = new JButton("Timeline");
        this.explorerAppButton = new JButton("Explorer");
        this.messengerAppButton = new JButton("Messenger");
        this.settingAppButton = new JButton("Setting");

        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.personalPageAppButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.timelineAppButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(this.explorerAppButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(this.messengerAppButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(this.settingAppButton, gbc);
    }
}
