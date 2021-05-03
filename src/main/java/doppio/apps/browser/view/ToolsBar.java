package doppio.apps.browser.view;

import javax.swing.*;
import java.awt.*;

public class ToolsBar extends JPanel {

    JButton backButton;
    JButton clearMainPanelButton;
    JButton exitButton;

    public ToolsBar() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(0, 50));
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        this.backButton = new JButton("Back");
        this.clearMainPanelButton = new JButton("Main Page");
        this.exitButton = new JButton("Exit");

        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(this.clearMainPanelButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(this.exitButton, gbc);
    }
}
