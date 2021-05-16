package doppio.apps.explorer.view.component.singletweetlabel;

import javax.swing.*;
import java.awt.*;

public class SingleTweetTextLabel extends JLabel {

    public SingleTweetTextLabel(String text) {
        this.setText(text);

        this.setPreferredSize(new Dimension(0, 40));
    }
}
