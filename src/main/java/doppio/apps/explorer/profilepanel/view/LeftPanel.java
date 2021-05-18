package doppio.apps.explorer.profilepanel.view;

import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    public LeftPanel() {
        this.setPreferredSize(new Dimension(explorerConfig.getLeftPanelWidth(), explorerConfig.getLeftPanelHeight()));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);
    }
}
