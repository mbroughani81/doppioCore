package doppio.apps.explorer.profilepanel.view;

import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    public RightPanel() {
        this.setPreferredSize(new Dimension(explorerConfig.getRightPanelWidth(), explorerConfig.getRightPanelHeight()));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
    }
}
