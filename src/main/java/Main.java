import doppio.apps.authentication.controller.AuthController;
import doppio.event.NewUserEvent;

public class Main {
    public static void main(String[] args) {
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
