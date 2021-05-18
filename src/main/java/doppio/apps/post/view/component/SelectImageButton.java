package doppio.apps.post.view.component;

import doppio.config.PostConfig;

import javax.swing.*;
import java.awt.*;

public class SelectImageButton extends JButton {

    PostConfig postConfig = new PostConfig();

    public SelectImageButton() {
        this.setPreferredSize(new Dimension(postConfig.getSelectImageButtonWidth(), postConfig.getSelectImageButtonHeight()));
        this.setText("Select image");
    }
}
