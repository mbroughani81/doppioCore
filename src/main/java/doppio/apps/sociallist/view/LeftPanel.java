package doppio.apps.sociallist.view;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel() {
        this.setPreferredSize(new Dimension(400, 0));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);
        this.setOpaque(true);
    }
}
