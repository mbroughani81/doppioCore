package doppio.apps.authentication.view;

import doppio.listener.StringInvoker;
import doppio.listener.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DefaultPanel extends JPanel implements StringInvoker, ActionListener {
    LoginButton loginButton;
    SignupButton signupButton;

    LinkedList<StringListener> stringListeners;

    public DefaultPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLUE);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        loginButton = new LoginButton();
        loginButton.addActionListener(this);
        signupButton = new SignupButton();
        signupButton.addActionListener(this);
        gbc.weightx = 0.1;
        gbc.weighty = 1;

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(signupButton, gbc);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            checkListeners("loginDefaultPanel");
        }
        if (e.getSource() == signupButton) {
            checkListeners("signupDefaultPanel");
        }
    }
}
