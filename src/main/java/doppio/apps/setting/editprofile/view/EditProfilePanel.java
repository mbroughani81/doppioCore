package doppio.apps.setting.editprofile.view;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.personalpage.view.ItemListPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.apps.post.model.Tweet;
import doppio.apps.setting.editprofile.listener.EditProfilePanelListener;
import doppio.event.NewCommentEvent;
import doppio.event.NewNameEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EditProfilePanel extends JPanel {
    static Logger logger = LogManager.getLogger(EditProfilePanel.class);

    ItemListPanel itemListPanel;
    ActionListener newProfileAction;
    ActionListener changeNameAction;
    ActionListener changeBirthdayAction;
    ActionListener changeEmailAction;
    ActionListener changePhonenumberAction;
    ActionListener changeBioAction;

    EditProfilePanelListener editProfilePanelListener;

    public EditProfilePanel(EditProfilePanelListener editProfilePanelListener) {
        logger.trace("EditProfilePanel is created");

        this.editProfilePanelListener = editProfilePanelListener;

        this.setBackground(Color.PINK);
        this.setOpaque(true);
        this.setLayout(new BorderLayout());

        newProfileAction = new NewProFileActionListener();
        changeNameAction = new ChangeNameAction();
        changeBirthdayAction = new ChangeBirthdayAction();
        changeEmailAction = new ChangeEmailAction();
        changePhonenumberAction = new ChangePhonenumberAction();
        changeBioAction = new ChangeBioAction();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("New profile", newProfileAction);
        itemListPanel.addButton("Change name", changeNameAction);
        itemListPanel.addButton("Change birthday", changeBirthdayAction);
        itemListPanel.addButton("Change email", changeEmailAction);
        itemListPanel.addButton("Change phonenumber", changePhonenumberAction);
        itemListPanel.addButton("Change bio", changeBioAction);

        this.add(itemListPanel, BorderLayout.CENTER);
    }

    class NewProFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("/home/mohammadbroughani/Pictures/niceimages/"));

            int respond = fileChooser.showOpenDialog(null);

            if (respond == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                Path path2 = Paths.get("src/main/resources/profileimages/");

                Path file1 = Paths.get(file.getAbsolutePath());
                Path file2 = path2.resolve(editProfilePanelListener.getUserId() + ".jpeg");

                try {
                    Files.deleteIfExists(file2);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(file1.toAbsolutePath() + "  editprofilepanel");
                System.out.println(file2.toAbsolutePath() + "  editprofilepanel");

                try {
                    Files.copy(file1, file2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ChangeNameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String newName = JOptionPane.showInputDialog("Write new name : ");
            User user = editProfilePanelListener.getUser();
            NewNameEvent event = new NewNameEvent(user, newName);
            editProfilePanelListener.setNewName(event);
        }
    }
    class ChangeBirthdayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class ChangeEmailAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class ChangePhonenumberAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class ChangeBioAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
