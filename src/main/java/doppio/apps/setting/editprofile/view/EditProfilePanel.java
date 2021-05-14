package doppio.apps.setting.editprofile.view;

import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.personalpage.view.ItemListPanel;
import doppio.apps.personalpage.view.PersonalPagePanel;
import doppio.apps.setting.editprofile.listener.EditProfilePanelListener;
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

    EditProfilePanelListener editProfilePanelListener;

    public EditProfilePanel(EditProfilePanelListener editProfilePanelListener) {
        logger.trace("EditProfilePanel is created");

        this.editProfilePanelListener = editProfilePanelListener;

        this.setBackground(Color.PINK);
        this.setOpaque(true);
        this.setLayout(new BorderLayout());

        newProfileAction = new NewProFileActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("New Profile", newProfileAction);

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

                System.out.println(file);
            }
        }
    }
}
