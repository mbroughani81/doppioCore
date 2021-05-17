package doppio.apps.explorer.explorerpanel.listener;

import doppio.apps.authentication.controller.AuthController;

public class SearchBoxListener {
    AuthController authController = new AuthController();

    public int getUserId(String username) {
        if (!authController.usernameExists(username))
            return -1;
        return authController.getUser(username).getId();
    }
}
