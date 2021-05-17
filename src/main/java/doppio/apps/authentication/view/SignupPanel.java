package doppio.apps.authentication.view;

import doppio.apps.authentication.exception.InvalidPasswordException;
import doppio.apps.authentication.exception.InvalidUsernameException;
import doppio.apps.authentication.view.listener.SignupPanelListener;
import doppio.event.FormEvent;
import doppio.event.NewUserEvent;
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

public class SignupPanel extends JPanel implements StringInvoker {

    static Logger logger = LogManager.getLogger(SignupPanel.class);

    TextField name;
    TextField username;
    TextField password;
    TextField birthday;
    TextField email;
    TextField phonenumber;
    TextField bio;
    JButton signupButton;
    JButton loginButton;

    SignupPanelListener signupPanelListener;
    LinkedList<StringListener> stringListeners = new LinkedList<>();

    public SignupPanel(SignupPanelListener signupPanelListener) {
        logger.trace("SignupPanel is created");

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.MAGENTA);
        this.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();

        name = new TextField();
        name.setPreferredSize(new Dimension(200, 20));
        username = new TextField();
        username.setPreferredSize(new Dimension(200, 20));
        password = new TextField();
        password.setPreferredSize(new Dimension(200, 20));
        birthday = new TextField();
        birthday.setPreferredSize(new Dimension(200, 20));
        email = new TextField();
        email.setPreferredSize(new Dimension(200, 20));
        phonenumber = new TextField();
        phonenumber.setPreferredSize(new Dimension(200, 20));
        bio = new TextField();
        bio.setPreferredSize(new Dimension(200, 20));
        signupButton = new SignupButton();
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("signupbutton in signuppanel const");
                checkListeners("signupSignupPanel");
                NewUserEvent event = new NewUserEvent(
                        username.getText(),
                        password.getText(),
                        name.getText(),
                        birthday.getText(),
                        email.getText(),
                        phonenumber.getText(),
                        bio.getText()
                );
                signupPanelListener.newUser(event);
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

        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(name, gbc);
        /////

        JLabel usernameLabel = new JLabel("Username : ");
        usernameLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(username, gbc);
        ////

        JLabel passworldLabel = new JLabel("Password : ");
        passworldLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(passworldLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(password, gbc);
        ////
        JLabel birthdayLabel = new JLabel("Birthday : ");
        birthdayLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(birthdayLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(birthday, gbc);
        ////
        JLabel emailLabel = new JLabel("Email : ");
        emailLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(email, gbc);
        ////
        JLabel phonenumberLabel = new JLabel("Phonenumber : ");
        phonenumberLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(phonenumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(phonenumber, gbc);
        ////
        JLabel bioLabel = new JLabel("Bio : ");
        bioLabel.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(bioLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        this.add(bio, gbc);
        ////
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(signupButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        this.add(loginButton, gbc);
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
