package doppio.apps.post.view;

import doppio.apps.post.listener.NewTweetPanelListener;
import doppio.apps.post.view.component.SendTweetButton;
import doppio.apps.post.view.component.TweetTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class NewTweetPanel extends JPanel implements ActionListener {

    NewTweetPanelListener newTweetPanelListener;

    TextField tweetTextField;
    JButton sendTweetButton;

    public NewTweetPanel(NewTweetPanelListener newTweetPanelListener) {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendTweetButton) {
            newTweetPanelListener.newTweet(tweetTextField.getText());
        }
    }
}
