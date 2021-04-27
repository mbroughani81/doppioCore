package doppio.apps.authentication.view;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {

    ImageIcon imageIcon;
    JLabel logoLabel;

    public LogoPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(0, 100));
        this.setBackground(Color.PINK);
        this.setOpaque(true);

        logoLabel = new JLabel();
        this.add(logoLabel, BorderLayout.CENTER);

        imageIcon = new ImageIcon("src/main/resources/images/logo.png");
        logoLabel.setIcon(imageIcon);
    }
}
