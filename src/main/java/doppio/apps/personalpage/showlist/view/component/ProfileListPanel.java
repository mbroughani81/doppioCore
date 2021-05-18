package doppio.apps.personalpage.showlist.view.component;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.view.component.singletweetlabel.ProfilePictureLabel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.config.PersonalpageConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class ProfileListPanel extends JPanel implements ProfileClickInvoker {

    PersonalpageConfig personalpageConfig = new PersonalpageConfig();

    LinkedList<User> users;

    ProfileClickListener profileClickListener;

    public ProfileListPanel() {
        this.setPreferredSize(new Dimension(personalpageConfig.getProfileListPanelWidth(), personalpageConfig.getProfileListPanelHeight()));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.PINK);
        this.setOpaque(true);

        users = new LinkedList<>();
    }

    public void addUser(User user) {
        users.add(user);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        for (User user1 : users) {
            ProfilePictureLabel label = new ProfilePictureLabel(user1.getId());
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    checkProfileClickListener(user1.getId());
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
            this.add(label, gbc);
            gbc.gridy++;
        }
        revalidate();
        repaint();
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
