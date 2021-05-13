package doppio.apps.explorer.profilepanel.view;

import javax.swing.*;
import java.awt.*;

public class BigProfileLabel extends JLabel {

    int userId;

    public BigProfileLabel(int userId) {
        this.userId = userId;

        this.setPreferredSize(new Dimension(200, 200));
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);

        ImageIcon imageIcon = new ImageIcon("src/main/resources/profileimages/" + userId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setIcon(imageIcon);
    }
}
