package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProfilePictureLabel extends JLabel {

    int creatorId;

    ProfileClickListener profileClickListener;

    public ProfilePictureLabel(int creatorId) {
        this.creatorId = creatorId;

        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(50, 50));

        File f = new File("src/main/resources/profileimages/" + creatorId + ".jpeg");
        ImageIcon imageIcon = new ImageIcon("src/main/resources/profileimages/" + creatorId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setIcon(imageIcon);
    }
}
