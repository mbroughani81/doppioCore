package doppio.apps.sociallist.view;

import javax.swing.*;
import java.awt.*;

public class ButtonHolder extends JPanel {
    public ButtonHolder() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(200, 50));
        this.setBackground(Color.RED);
        this.setOpaque(true);
    }
}
