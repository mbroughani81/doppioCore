package doppio.apps.messenger.view.component;

import doppio.apps.explorer.view.component.singletweetlabel.ProfilePictureLabel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.messenger.model.Pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PmLabel extends JLabel implements ProfileClickInvoker {

    JLabel textLabel;
    JLabel profilePicture;

    ProfileClickListener profileClickListener;

    public PmLabel(Pm pm) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(400, 60));


        textLabel = new JLabel();
        textLabel.setText(pm.getText());
        add(textLabel, BorderLayout.CENTER);

        profilePicture = new ProfilePictureLabel(pm.getUserId());
        profilePicture.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                checkProfileClickListener(pm.getUserId());
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        add(profilePicture, BorderLayout.WEST);
    }

    @Override
    public void setProfileClickListener(ProfileClickListener listener) {
        this.profileClickListener = listener;
    }

    @Override
    public void checkProfileClickListener(int userId) {
        this.profileClickListener.runProfileClickListener(userId);
    }
}
