package doppio.apps.explorer.view.component.singletweetlabel;

import doppio.apps.authentication.model.User;
import doppio.apps.explorer.view.component.singletweetlabel.listener.SingelTweetBottomBarListener;
import doppio.apps.post.model.Tweet;
import doppio.event.NewCommentEvent;
import doppio.event.NewRetweetEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleTweetBottomBar extends JPanel implements ActionListener {

    JButton likeButton;
    JButton retweetButton;
    JButton commentButton;
    JButton otherButton;

    SingelTweetBottomBarListener singelTweetBottomBarListener;

    public SingleTweetBottomBar(SingelTweetBottomBarListener singelTweetBottomBarListener) {
        this.singelTweetBottomBarListener = singelTweetBottomBarListener;

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(0, 40));
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
        if (e.getSource() == otherButton) {
//            JOptionPane.showMessageDialog(null, "salam", "sample", JOptionPane.PLAIN_MESSAGE);
            String[] responses = {"1", "2a", "3", "4"};
//            int answer = JOptionPane.showOptionDialog(
//                    null,
//                    "Hi",
//                    "sample",
//                    JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.INFORMATION_MESSAGE,
//                    null,
//                    responses,
//                    0
//            );
//            String answer = JOptionPane.showInputDialog("salam\n\n\n", "\n\n\n\n\n");
//            System.out.println(answer + "is answer actioperfomed singletweetbuttombar");

        }
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
        if (e.getSource() == otherButton) {
            String[] responses = {"Spam"};
            int res = JOptionPane.showOptionDialog(
                    null,
                    "test",
                    "test",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    responses,
                    0
            );
            if (res == 0) {
                singelTweetBottomBarListener.reportSpam();
            }
            System.out.println(res + " singletweetbottombar");
        }
    }
}
