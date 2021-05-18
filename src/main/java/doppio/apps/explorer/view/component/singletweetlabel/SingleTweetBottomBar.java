package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.view.component.singletweetlabel.listener.SingelTweetBottomBarListener;
import doppio.apps.messenger.model.UserType;
import doppio.apps.messenger.view.component.NewTypeOptionPanel;
import doppio.apps.post.model.Tweet;
import doppio.config.ExplorerConfig;
import doppio.event.NewCommentEvent;
import doppio.event.NewLikeEvent;
import doppio.event.NewPmEvent;
import doppio.event.NewRetweetEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class SingleTweetBottomBar extends JPanel implements ActionListener {

    ExplorerConfig explorerConfig = new ExplorerConfig();

    JButton likeButton;
    JButton retweetButton;
    JButton commentButton;
    JButton otherButton;

    SingelTweetBottomBarListener singelTweetBottomBarListener;

    public SingleTweetBottomBar(SingelTweetBottomBarListener singelTweetBottomBarListener) {
        this.singelTweetBottomBarListener = singelTweetBottomBarListener;

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(explorerConfig.getSingleTweetBottomBarWidth(), explorerConfig.getSingleTweetBottomBarHeight()));
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        commentButton = new CommentButton();
        commentButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(commentButton, gbc);
        retweetButton = new RetweetButton();
        retweetButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(retweetButton, gbc);
        likeButton = new LikeButton();
        likeButton.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(likeButton, gbc);
        otherButton = new OtherButton();
        otherButton.addActionListener(this);
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(otherButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == commentButton) {
            String commentText = JOptionPane.showInputDialog("Write comment : ");
            System.out.println(commentText + " is singletweetbottombor");
            User user = singelTweetBottomBarListener.getUser();
            Tweet tweet = singelTweetBottomBarListener.getTweet();
            NewCommentEvent event = new NewCommentEvent(tweet, user, commentText);
            singelTweetBottomBarListener.newComment(event);
        }
        if (e.getSource() == retweetButton) {
            Tweet tweet = singelTweetBottomBarListener.getTweet();
            User user = singelTweetBottomBarListener.getUser();
            NewRetweetEvent event = new NewRetweetEvent(tweet, user);
            singelTweetBottomBarListener.newRetweet(event);
        }
        if (e.getSource() == likeButton) {
            System.out.println("hummm singletweetbottombar");
            User user = singelTweetBottomBarListener.getUser();
            Tweet tweet = singelTweetBottomBarListener.getTweet();
            NewLikeEvent event = new NewLikeEvent(user.getId(), tweet.getId());
            singelTweetBottomBarListener.addLike(event);
        }
        if (e.getSource() == otherButton) {
            String[] responses = {"Spam", "Block user", "Mute", "Forward", "Save message"};
            int res = JOptionPane.showOptionDialog(
                    null,
                    "Select action",
                    "Other",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    responses,
                    0
            );
            if (res == 0) {
                singelTweetBottomBarListener.reportSpam();
            }
            if (res == 1) {
                singelTweetBottomBarListener.blockUser();
            }
            if (res == 2) {
                singelTweetBottomBarListener.muteUser();
            }
            if (res == 3) {
                String messageText = singelTweetBottomBarListener.getTweet().getText();
                NewTypeOptionPanel panel1 = new NewTypeOptionPanel();
                for (UserType userType : singelTweetBottomBarListener.getTypes()) {
                    panel1.addItem(userType.getId(), userType.getUserTypeName());
                }
                NewTypeOptionPanel panel2 = new NewTypeOptionPanel();
                for (int id : singelTweetBottomBarListener.getFollowingIds()) {
                    panel2.addItem(id, singelTweetBottomBarListener.getUser(id).getUsername());
                }
                int ans1 = JOptionPane.showOptionDialog(null, panel1, "Choose UserTypes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                int ans2 = JOptionPane.showOptionDialog(null, panel2, "Choose User", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                LinkedList<Integer> userIds = new LinkedList<>();
                if (ans1 == 0) {
                    for (int id : panel1.getSelectedItemsFirst()) {
                        for (int userId : singelTweetBottomBarListener.getUserType(id).getUserIds()) {
                            if (!userIds.contains(userId))
                                userIds.add(userId);
                        }
                    }
                }
                if (ans2 == 0) {
                    for (int id : panel2.getSelectedItemsFirst()) {
                        if (!userIds.contains(id))
                            userIds.add(id);
                    }
                }
                for (int id : userIds) {
                    int chatId = singelTweetBottomBarListener.getChatId(id);
                    NewPmEvent event = new NewPmEvent(singelTweetBottomBarListener.getUser().getId(), chatId, messageText);
                    singelTweetBottomBarListener.newPm(event);
                }
            }
            if (res == 4) {
                String messageText = singelTweetBottomBarListener.getTweet().getText();
                singelTweetBottomBarListener.sendPmToSavedMessage(messageText);
            }
        }
    }
}
