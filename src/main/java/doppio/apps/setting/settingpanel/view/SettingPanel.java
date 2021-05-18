package doppio.apps.setting.settingpanel.view;

import doppio.apps.authentication.model.LastSeenPrivacy;
import doppio.apps.authentication.model.Privacy;
import doppio.apps.authentication.model.User;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.personalpage.view.ItemListPanel;
import doppio.apps.setting.settingpanel.listener.SettingPanelListener;
import doppio.event.NewNameEvent;
import doppio.event.NewPasswordEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingPanel extends JPanel {
    static Logger logger = LogManager.getLogger(SettingPanel.class);

    ItemListPanel itemListPanel;

    ActionListener privacyActionListener;
    ActionListener lastSeenPrivacyActionListener;
    ActionListener setActivityActionListener;
    ActionListener changePasswordActionListener;
    ActionListener deleteAccountActionListener;
    ActionListener logoutActionListener;

    SettingPanelListener settingPanelListener;

    public SettingPanel(SettingPanelListener settingPanelListener) {
        logger.trace("SettingPanel is created");

        this.settingPanelListener = settingPanelListener;

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
            String[] options = {"Public", "Private"};
            String ans = (String) JOptionPane.showInputDialog(
                    null,
                    "Select privacy : ",
                    "Change privacy",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            System.out.println(ans + " pricavyactionlistener settingpanel");
            if (ans != null) {
                System.out.println("goddo settingpanel");
                if (ans.equals("Public"))
                    settingPanelListener.changePrivacy(Privacy.PUBLIC);
                else
                    settingPanelListener.changePrivacy(Privacy.PRIVATE);
            }
        }
    }
    class LastSeenPrivacyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String[] options = {"Everybody", "Nobody", "Following"};
            String ans = (String) JOptionPane.showInputDialog(
                    null,
                    "Select last seen privacy : ",
                    "Change last seen privacy",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            System.out.println(ans + " pricavyactionlistener settingpanel");
            if (ans != null) {
                System.out.println("goddo settingpanel");
                if (ans.equals("Everybody"))
                    settingPanelListener.changeLastSeenPrivacy(LastSeenPrivacy.EVERYBODY);
                if (ans.equals("Nobody"))
                    settingPanelListener.changeLastSeenPrivacy(LastSeenPrivacy.NOBODY);
                if (ans.equals("Following"))
                    settingPanelListener.changeLastSeenPrivacy(LastSeenPrivacy.FOLLOWING);
            }
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
            String newPassword = JOptionPane.showInputDialog("Write new password : ");
            User user = settingPanelListener.getUser();
            NewPasswordEvent event = new NewPasswordEvent(user, newPassword);
            settingPanelListener.setNewPassword(event);
        }
    }
    class DeleteAccountActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settingPanelListener.deleteAccount();
        }
    }
    class LogoutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
