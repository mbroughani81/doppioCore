package doppio.apps.post.listener;

import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.controller.SessionController;
import doppio.event.NewTweetEvent;

public class NewTweetPanelListener {
    PostController postController;
    AuthController authController;
    SessionController sessionController;

    public NewTweetPanelListener() {
        postController = new PostController();
        authController = new AuthController();
        sessionController = new SessionController();
    }

    public int newTweet(String text) {
        int userId = sessionController.getSession(0).getUserId();
        User user = authController.getUser(userId);
        NewTweetEvent event = new NewTweetEvent(user, text);
        return postController.newTweet(event);
    }

}
