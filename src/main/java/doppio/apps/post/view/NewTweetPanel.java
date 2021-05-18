package doppio.apps.post.view;

import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.post.listener.NewTweetPanelListener;
import doppio.apps.post.view.component.SelectImageButton;
import doppio.apps.post.view.component.SendTweetButton;
import doppio.apps.post.view.component.TweetTextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class NewTweetPanel extends JPanel implements ActionListener {
    static Logger logger = LogManager.getLogger(NewTweetPanel.class);

    NewTweetPanelListener newTweetPanelListener;

    TextField tweetTextField;
    JButton sendTweetButton;
    JButton selectImageButton;
    String imagePath;

    public NewTweetPanel(NewTweetPanelListener newTweetPanelListener) {
        logger.trace("NewTweetPanel is created");

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.RED);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        this.newTweetPanelListener = newTweetPanelListener;

        tweetTextField = new TweetTextField();
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(tweetTextField, gbc);

        sendTweetButton = new SendTweetButton();
        sendTweetButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(sendTweetButton, gbc);

        selectImageButton = new SelectImageButton();
        selectImageButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(selectImageButton, gbc);

        imagePath = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendTweetButton) {
            int tweetId = newTweetPanelListener.newTweet(tweetTextField.getText());
            if (imagePath.length() > 0) {
                File file = new File(imagePath);

                Path path2 = Paths.get("src/main/resources/tweetimages/");

                Path file1 = Paths.get(file.getAbsolutePath());
                Path file2 = path2.resolve(tweetId + ".jpeg");

                try {
                    Files.deleteIfExists(file2);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

                System.out.println(file1.toAbsolutePath() + "  newtweetpanel");
                System.out.println(file2.toAbsolutePath() + "  newtweetpanel");

                try {
                    Files.copy(file1, file2);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                imagePath = "";
            }
        }
        if (e.getSource() == selectImageButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("/home/mohammadbroughani/Pictures/niceimages/"));

            int respond = fileChooser.showOpenDialog(null);
            System.out.println(respond + " " + fileChooser.getSelectedFile().getAbsolutePath() + " newtweetpanel");
            if (respond == JFileChooser.APPROVE_OPTION) {
                imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            }
        }
    }
}
