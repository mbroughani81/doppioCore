package doppio.apps.personalpage.view;

import doppio.apps.explorer.showtweets.showusertweets.view.ShowUserTweetsPanel;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickInvoker;
import doppio.apps.explorer.view.component.singletweetlabel.listener.ProfileClickListener;
import doppio.apps.personalpage.view.listener.PersonalPagePanelListener;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PersonalPagePanel extends JPanel implements StringInvoker, ProfileClickInvoker {
    static Logger logger = LogManager.getLogger(PersonalPagePanel.class);

    PersonalPagePanelListener personalPagePanelListener;

    ItemListPanel itemListPanel;
    ActionListener newTweetAction;
    ActionListener showTweetsAction;
    ActionListener editProfileAction;
    ActionListener showListsAction;
    ActionListener infoAction;
    ActionListener notificationsAction;

    LinkedList<StringListener> stringListeners;

    ProfileClickListener profileClickListener;

    public PersonalPagePanel(PersonalPagePanelListener personalPagePanelListener) {
        logger.trace("PersonalPagePanel is created");

        this.personalPagePanelListener = personalPagePanelListener;

        this.setLayout(new BorderLayout());

        newTweetAction = new NewTweetActionListener();
        showTweetsAction = new ShowTweetsActionListener();
        editProfileAction = new EditProfileActionListener();
        showListsAction = new ShowListsActionListener();
        infoAction = new InfoActionListener();
        notificationsAction = new NotificationsActionListener();

        itemListPanel = new ItemListPanel();
        itemListPanel.addButton("NewTweet", newTweetAction);
        itemListPanel.addButton("Show Tweets", showTweetsAction);
        itemListPanel.addButton("Edit Profile", editProfileAction);
        itemListPanel.addButton("Show Lists", showListsAction);
        itemListPanel.addButton("Info", infoAction);
        itemListPanel.addButton("Notifications", notificationsAction);
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

    class ShowListsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("makes sense personalpagepanel");
            checkListeners("showListsPersonalPagePanel");
        }
    }

    class NotificationsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            checkListeners("notificationsPersonalPagePanel");
        }
    }
    class InfoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            checkProfileClickListener(personalPagePanelListener.getUserId());
        }
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

