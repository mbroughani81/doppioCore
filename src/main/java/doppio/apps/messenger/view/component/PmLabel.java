package doppio.apps.messenger.view.component;

import doppio.apps.messenger.model.Pm;

import javax.swing.*;
import java.awt.*;

public class PmLabel extends JLabel {

    public PmLabel(Pm pm) {
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setText(pm.getText());
        this.setPreferredSize(new Dimension(400, 30));

//        this.setText(text);
    }
}
