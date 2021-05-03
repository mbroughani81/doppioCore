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

    LinkedList<StringListener> stringListeners;

    public PersonalPagePanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        newTweetAction = new NewTweetActionListener();
        showTweetsAction = new ShowTweetsActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("NewTweet", newTweetAction);
        itemListPanel.addButton("Show Tweets", showTweetsAction);
        itemListPanel.addButton("Edit Profile", newTweetAction);
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
            System.out.println("goto change panel to newtweet newtweetactionlistener class in personalpagepanel");
        }
    }

    class ShowTweetsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("goto change panel to showtweet ShowTweetsActionListener class in personalpagepanel");
            checkListeners("showTweetsPersonalPagePanel");
        }
    }
}

