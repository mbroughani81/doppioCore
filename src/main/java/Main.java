import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.event.NewTweetEvent;
import doppio.event.NewUserEvent;

public class Main {
    public static void main(String[] args) {
//        testNewUser();

//        testNewTweet();
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        authController.clearProfileDB();
        authController.clearUserDB();
        testNewUser();
        User u = authController.getUser("mb");
        NewTweetEvent newTweetEvent = new NewTweetEvent(u, "sallap");
        postController.newTweet(newTweetEvent);
    }

    public static void testNewUser() {
        AuthController authController = new AuthController();
        String username = "mb";
        String password = "1381";
        String name = "name";
        String birthday = "day";
        String email = "mb@81.com";
        String phoneNumber = "123";
        String bio = "khoshhal";
        NewUserEvent event = new NewUserEvent(username, password, name, birthday, email, phoneNumber, bio);
        authController.addUser(event);
    }
}
