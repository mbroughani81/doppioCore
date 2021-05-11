package doppio.apps.setting.settingpanel.view;

import doppio.apps.personalpage.view.ItemListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingPanel extends JPanel {

    ItemListPanel itemListPanel;

    ActionListener privacyActionListener;
    ActionListener lastSeenPrivacyActionListener;
    ActionListener setActivityActionListener;
    ActionListener changePasswordActionListener;
    ActionListener deleteAccountActionListener;
    ActionListener logoutActionListener;

    public SettingPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setOpaque(true);

        privacyActionListener = new PrivacyActionListener();
        lastSeenPrivacyActionListener = new LastSeenPrivacyActionListener();
        setActivityActionListener = new SetActivityActionListener();
        changePasswordActionListener = new ChangePasswordActionListener();
        deleteAccountActionListener = new DeleteAccountActionListener();
        logoutActionListener = new LogoutActionListener();

        itemListPanel = new ItemListPanel();

        itemListPanel.addButton("Privacy", privacyActionListener);
        itemListPanel.addButton("Last seen Privacy", lastSeenPrivacyActionListener);
        itemListPanel.addButton("Set activity", setActivityActionListener);
        itemListPanel.addButton("Change password", changePasswordActionListener);
        itemListPanel.addButton("Delete account", deleteAccountActionListener);
        itemListPanel.addButton("Logout", logoutActionListener);

        this.add(itemListPanel, BorderLayout.CENTER);
    }

    class PrivacyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class LastSeenPrivacyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class SetActivityActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class ChangePasswordActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class DeleteAccountActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class LogoutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
