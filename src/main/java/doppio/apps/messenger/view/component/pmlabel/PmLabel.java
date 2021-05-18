package doppio.apps.messenger.view.component.pmlabel;

import doppio.apps.explorer.view.component.singletweetlabel.ProfilePictureLabel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.messenger.model.Pm;
import doppio.config.MessengerConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PmLabel extends JLabel implements ProfileClickInvoker {

    MessengerConfig messengerConfig = new MessengerConfig();

    JLabel textLabel;
    JLabel profilePicture;
    JLabel pmImageLabel;

    ProfileClickListener profileClickListener;

    public PmLabel(Pm pm, int align) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(messengerConfig.getPmLabelWidth(), messengerConfig.getPmLabelHeight()));

        textLabel = new JLabel();
        textLabel.setText(pm.getText());
        add(textLabel, BorderLayout.CENTER);

        pmImageLabel = new PmImageLabel(pm.getId());
        add(pmImageLabel, BorderLayout.SOUTH);

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
        if (align == 0)
            add(profilePicture, BorderLayout.WEST);
        else
            add(profilePicture, BorderLayout.EAST);
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
