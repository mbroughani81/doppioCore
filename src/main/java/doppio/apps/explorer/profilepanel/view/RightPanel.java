package doppio.apps.explorer.profilepanel.view;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel() {
        this.setPreferredSize(new Dimension(300, 0));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
    }
}
