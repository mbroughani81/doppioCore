package doppio.apps.explorer.view.component.singletweetlabel;

import javax.swing.*;
import java.awt.*;

public class TweetContentPanel extends JPanel {

    public TweetContentPanel() {
        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(0, 0));
    }

    public void addPreferredSize(JComponent component) {
        this.setPreferredSize(new Dimension(
                (int)getPreferredSize().getWidth(),
                (int)getPreferredSize().getHeight() + (int)component.getPreferredSize().getHeight()
        ));
    }
}
