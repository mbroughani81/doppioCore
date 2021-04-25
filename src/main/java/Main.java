import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.event.NewCommentEvent;
import doppio.event.NewRetweetEvent;
import doppio.event.NewTweetEvent;
import doppio.event.NewUserEvent;

public class Main {
    public static void main(String[] args) {
//        testNewRetweet();
//        testNewComment();

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

    public static void testNewTweet() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        authController.clearProfileDB();
        authController.clearUserDB();
        testNewUser();
        User u = authController.getUser("mb");
        NewTweetEvent newTweetEvent = new NewTweetEvent(u, "sallap");
        postController.newTweet(newTweetEvent);
    }

    public static void testNewRetweet() {
        PostController postController = new PostController();
        AuthController authController = new AuthController();
        postController.clearTweetDB();
        testNewTweet();
        Tweet original = postController.getTweet(0);
        User user = authController.getUser("mb");
        NewRetweetEvent event = new NewRetweetEvent(original, user);
        postController.newRetweet(event);
    }

    public static void testNewComment() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        authController.clearUserDB();
        authController.clearProfileDB();
        postController.clearTweetDB();
        testNewTweet();
        Tweet t = postController.getTweet(0);

        String username = "ak";
        String password = "1388";
        String name = "namee";
        String birthday = "dayy";
        String email = "ak@81.com";
        String phoneNumber = "1233";
        String bio = "khoshhal inf";
        NewUserEvent event = new NewUserEvent(username, password, name, birthday, email, phoneNumber, bio);
        authController.addUser(event);

        User u = authController.getUser("ak");
        NewCommentEvent e = new NewCommentEvent(t, u, "salam dash");
        postController.newComment(e);
    }
}
