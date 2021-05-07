package doppio.apps.messenger.view.component;

import javax.swing.*;
import java.awt.*;

public class PmLabel extends JLabel {

    public PmLabel(String text) {
        this.setPreferredSize(new Dimension(300, 30));
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.setText(text);
    }
}
