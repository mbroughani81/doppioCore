package doppio.apps.explorer.profilepanel.view;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    public LeftPanel() {
        this.setPreferredSize(new Dimension(500, 0));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);
    }
}
