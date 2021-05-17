package doppio.apps.authentication.view;

import doppio.apps.authentication.exception.InvalidPasswordException;
import doppio.apps.authentication.exception.InvalidUsernameException;
import doppio.event.FormEvent;
import doppio.listener.FormInvoker;
import doppio.listener.FormListener;
import doppio.listener.StringInvoker;
import doppio.listener.StringListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class LoginPanel extends JPanel implements StringInvoker, FormInvoker {

    static Logger logger = LogManager.getLogger(LoginPanel.class);

    TextField username;
    TextField password;
    JButton signupButton;
    JButton loginButton;
    JLabel errorLabel;

    LinkedList<StringListener> stringListeners;
    LinkedList<FormListener> formListeners;

    public LoginPanel() {
        logger.trace("LoginPanel is created");

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.RED);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        errorLabel = new JLabel();
        errorLabel.setPreferredSize(new Dimension(300, 50));
        username = new TextField();
        username.setPreferredSize(new Dimension(200, 20));
        password = new TextField();
        password.setPreferredSize(new Dimension(200, 20));
        signupButton = new SignupButton();
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkListeners("signupLoginPanel");
            }
        });
        loginButton = new LoginButton();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormEvent event = new FormEvent(
                        LoginPanel.this,
                        username.getText(),
                        password.getText()
                );
                try {
                    checkFormListeners(event);
                    checkListeners("loginLoginPanel");
                } catch (InvalidPasswordException | InvalidUsernameException e) {
                    errorLabel.setText(e.getMessage());
                }
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
        this.add(errorLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(signupButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(loginButton, gbc);



        stringListeners = new LinkedList<>();
        formListeners = new LinkedList<>();
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

    @Override
    public void checkFormListeners(FormEvent event) throws InvalidPasswordException, InvalidUsernameException {
        for (FormListener formListener : formListeners) {
            formListener.eventOccurred(event);
        }
    }

    @Override
    public void addFormListener(FormListener listener) {
        formListeners.add(listener);
    }
}
