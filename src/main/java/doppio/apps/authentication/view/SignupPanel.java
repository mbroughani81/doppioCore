package doppio.apps.authentication.view;

import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class SignupPanel extends JPanel implements StringInvoker {

    TextField username;
    TextField password;
    JButton signupButton;
    JButton loginButton;

    LinkedList<StringListener> stringListeners;

    public SignupPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        username = new TextField();
        username.setPreferredSize(new Dimension(200, 20));
        password = new TextField();
        password.setPreferredSize(new Dimension(200, 20));
        signupButton = new SignupButton();
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("signupbutton in signuppanel const");
                checkListeners("signupSignupPanel");
            }
        });
        loginButton = new LoginButton();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("loginbutton in signuppanel const");
                checkListeners("loginSignupPanel");
            }
        });

        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel t1 = new JLabel("Username : ");
        t1.setPreferredSize(new Dimension(100, 20));
        this.add(t1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(username, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel t2 = new JLabel("Password : ");
        t2.setPreferredSize(new Dimension(100, 20));
        this.add(t2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(signupButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(loginButton, gbc);

        stringListeners = new LinkedList<>();
    }

    @Override
    public void checkListeners(String s) {
        for (StringListener sl : stringListeners) {
            sl.run(s);
        }
    }

    @Override
    public void addListener(StringListener listener) {
        stringListeners.add(listener);
    }
}
