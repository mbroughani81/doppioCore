import doppio.apps.authentication.controller.AuthController;
import doppio.apps.authentication.model.User;
import doppio.apps.messenger.controller.MessageController;
import doppio.apps.messenger.controller.PmController;
import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.controller.SocialListController;
import doppio.controller.SessionController;
import doppio.event.*;

public class Main {
    public static void main(String[] args) {
        testNewSession();
//        SessionController sessionController = new SessionController();
//        sessionController.clearSessionDB();
        doppio.Main.main(args);
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
        // first tweet of mb
        User u = authController.getUser("mb");
        NewTweetEvent newTweetEvent = new NewTweetEvent(u, "post1");
        postController.newTweet(newTweetEvent);
        // second tweet of mb
        User u1 = authController.getUser("mb");
        NewTweetEvent newTweetEvent1 = new NewTweetEvent(u1, "post2");
        postController.newTweet(newTweetEvent1);
        // second tweet of mb
        User u2 = authController.getUser("mb");
        NewTweetEvent newTweetEvent2 = new NewTweetEvent(u1, "post3");
        postController.newTweet(newTweetEvent2);
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

        username = "gg";
        password = "1388";
        name = "namee";
        birthday = "dayy";
        email = "gg@81.com";
        phoneNumber = "1233";
        bio = "khoshhal asf";
        NewUserEvent event1 = new NewUserEvent(username, password, name, birthday, email, phoneNumber, bio);
        authController.addUser(event1);

        User u = authController.getUser("ak");
        NewCommentEvent e = new NewCommentEvent(t, u, "salam dash");
        postController.newComment(e);
    }

    public static void testAddToBlock() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        SocialListController socialListController = new SocialListController();
        authController.clearProfileDB();
        authController.clearUserDB();
        postController.clearTweetDB();
        socialListController.clearBlackListDB();
        testNewComment();
        User a = authController.getUser("ak");
        User b = authController.getUser("mb");
        AddToBlockedEvent event = new AddToBlockedEvent(a, b);
        socialListController.addToBlocked(event);
    }

    public static void testAddToFollower() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        SocialListController socialListController = new SocialListController();
        authController.clearProfileDB();
        authController.clearUserDB();
        postController.clearTweetDB();
        socialListController.clearBlackListDB();
        socialListController.clearFollowerListDB();
        socialListController.clearFollowingListDB();
        testNewComment();
        User a = authController.getUser("mb");
        User b = authController.getUser("ak");
        socialListController.addToFollower(new AddToFollowerEvent(a, b));
    }

    public static void testNewPrivateChat() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        SocialListController socialListController = new SocialListController();
        MessageController messageController = new MessageController();
        authController.clearProfileDB();
        authController.clearUserDB();
        postController.clearTweetDB();
        socialListController.clearBlackListDB();
        socialListController.clearFollowerListDB();
        socialListController.clearFollowingListDB();
        messageController.clearMessageDataDB();
        messageController.clearPrivateChatDB();
        messageController.clearGroupChatDB();
        testAddToFollower();
        User user1 = authController.getUser("mb");
        User user2 = authController.getUser("ak");
        User user3 = authController.getUser("gg");
        NewPrivateChatEvent event = new NewPrivateChatEvent(user1.getId(), user2.getId());
        messageController.newPrivateChat(event);
        event = new NewPrivateChatEvent(user2.getId(), user3.getId());
        messageController.newPrivateChat(event);
    }
    public static void testDeleteUser() {
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        SocialListController socialListController = new SocialListController();
        MessageController messageController = new MessageController();
        authController.clearProfileDB();
        authController.clearUserDB();
        postController.clearTweetDB();
        socialListController.clearBlackListDB();
        socialListController.clearFollowerListDB();
        socialListController.clearFollowingListDB();
        messageController.clearMessageDataDB();
        messageController.clearPrivateChatDB();
        messageController.clearGroupChatDB();

        testAddToBlock();
        User b = authController.getUser("mb");
        authController.deleteUser(b);
    }

    public static void testNewSession() {
        SessionController sessionController = new SessionController();
        AuthController authController = new AuthController();
        PostController postController = new PostController();
        SocialListController socialListController = new SocialListController();
        MessageController messageController = new MessageController();
        PmController pmController = new PmController();
        authController.clearProfileDB();
        authController.clearUserDB();
        postController.clearTweetDB();
        socialListController.clearBlackListDB();
        socialListController.clearFollowerListDB();
        socialListController.clearFollowingListDB();
        messageController.clearMessageDataDB();
        messageController.clearPrivateChatDB();
        messageController.clearGroupChatDB();
        sessionController.clearSessionDB();
        pmController.clearPmDB();
        testNewPrivateChat();
    }

}
