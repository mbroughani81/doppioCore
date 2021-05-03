package doppio.apps.browser.view;

import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame {
    public BrowserFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setVisible(true);

    }
}
