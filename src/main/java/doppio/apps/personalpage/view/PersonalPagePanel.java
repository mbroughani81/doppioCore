package doppio.apps.personalpage.view;

import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PersonalPagePanel extends JPanel implements StringInvoker {

    ItemListPanel itemListPanel;
    ActionListener newTweetAction;
    ActionListener showTweetsAction;
    ActionListener editProfileAction;

    LinkedList<StringListener> stringListeners;

    public PersonalPagePanel() {
        this.setLayout(new BorderLayout());

        newTweetAction = new NewTweetActionListener();
        showTweetsAction = new ShowTweetsActionListener();
        editProfileAction = new EditProfileActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("NewTweet", newTweetAction);
        itemListPanel.addButton("Show Tweets", showTweetsAction);
        itemListPanel.addButton("Edit Profile", editProfileAction);
        itemListPanel.addButton("Show Lists", newTweetAction);
        itemListPanel.addButton("Info", newTweetAction);
        itemListPanel.addButton("Notifications", newTweetAction);

        this.add(itemListPanel, BorderLayout.CENTER);

        stringListeners = new LinkedList<>();
    }

    @Override
    public void checkListeners(String s) {
        for (StringListener listener : stringListeners)
            listener.run(s);
    }

    @Override
    public void addListener(StringListener listener) {
        stringListeners.add(listener);
    }


    class NewTweetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("goto change panel to newtweet newtweetactionlistener class in personalpagepanel");
            checkListeners("newTweetPersonalPagePanel");
        }
    }

    class ShowTweetsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("goto change panel to showtweet ShowTweetsActionListener class in personalpagepanel");
            checkListeners("showTweetsPersonalPagePanel");
        }
    }

    class EditProfileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("goto change panel to showtweet ShowTweetsActionListener class in personalpagepanel");
            checkListeners("editProfilePersonalPagePanel");
        }
    }
}

