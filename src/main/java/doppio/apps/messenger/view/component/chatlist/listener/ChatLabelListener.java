package doppio.apps.messenger.view.component.chatlist.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.messenger.model.Chat;
import doppio.apps.messenger.model.Pm;

public class ChatLabelListener {
    AuthController authController = new AuthController();
    PmController pmController = new PmController();

    public String getUsername(int userId) {
        return authController.getUser(userId).getUsername();
    }
}
