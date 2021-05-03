package doppio.apps.personalpage.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalPagePanel extends JPanel {

    ItemListPanel itemListPanel;
    ActionListener newTweetAction;

    public PersonalPagePanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        newTweetAction = new NewTweetActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("NewTweet", newTweetAction);
        itemListPanel.addButton("Show Tweets", newTweetAction);
        itemListPanel.addButton("Edit Profile", newTweetAction);
        itemListPanel.addButton("Show Lists", newTweetAction);
        itemListPanel.addButton("Info", newTweetAction);
        itemListPanel.addButton("Notifications", newTweetAction);

        this.add(itemListPanel, BorderLayout.CENTER);
    }
}

class NewTweetActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("goto change panel to newtweet newtweetactionlistener class in personalpagepanel");
    }
}
