package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.config.ExplorerConfig;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProfilePictureLabel extends JLabel {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    int creatorId;

    public ProfilePictureLabel(int creatorId) {
        this.creatorId = creatorId;

        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(explorerConfig.getProfilePictureLabelWidth(), explorerConfig.getProfilePictureLabelHeight()));

        ImageIcon imageIcon = new ImageIcon(explorerConfig.getProfileImagesPath() + creatorId + ".jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(explorerConfig.getProfilePictureLabelWidth(), explorerConfig.getProfilePictureLabelHeight(), Image.SCALE_FAST);
        imageIcon.setImage(newImage);
        this.setIcon(imageIcon);
    }
}
