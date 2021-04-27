package doppio;

import doppio.apps.authentication.view.AuthenticationWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new Sig
                new AuthenticationWindow();
            }
        });
    }
}
