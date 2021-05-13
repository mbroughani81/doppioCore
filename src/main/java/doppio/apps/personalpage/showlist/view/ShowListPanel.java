package doppio.apps.personalpage.showlist.view;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.personalpage.showlist.listener.ShowListPanelListener;
import doppio.apps.personalpage.showlist.view.component.ProfileListPanel;

import javax.swing.*;
import java.awt.*;

public class ShowListPanel extends JPanel implements ProfileClickInvoker {


    ProfileClickListener profileClickListener;
    ProfileListPanel followingListPanel;
    ProfileListPanel followersListPanel;
    ProfileListPanel blockedListPanel;

    ShowListPanelListener showListPanelListener;

    public ShowListPanel(ShowListPanelListener showListPanelListener) {
        this.showListPanelListener = showListPanelListener;
        this.setLayout(new BorderLayout());
//        this.setBackground(Color.PINK);
//        this.setOpaque(true);

        followingListPanel = new ProfileListPanel();
        followingListPanel.setBackground(Color.CYAN);
        followingListPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        for (User user : showListPanelListener.getFollowing()) {
            followingListPanel.addUser(user);
        }
        add(followingListPanel, BorderLayout.WEST);

        followersListPanel = new ProfileListPanel();
        followersListPanel.setBackground(Color.RED);
        followersListPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        for (User user : showListPanelListener.getFollowers()) {
            followersListPanel.addUser(user);
        }
        add(followersListPanel, BorderLayout.CENTER);

        blockedListPanel = new ProfileListPanel();
        blockedListPanel.setBackground(Color.LIGHT_GRAY);
        blockedListPanel.setProfileClickListener(new ProfileClickListener() {
            @Override
            public void runProfileClickListener(int userId) {
                checkProfileClickListener(userId);
            }
        });
        for (User user : showListPanelListener.getBlocked()) {
            blockedListPanel.addUser(user);
        }
        add(blockedListPanel, BorderLayout.EAST);
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
