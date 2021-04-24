package doppio.event;

public class NewUserEvent {
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String email;
    private String phoneNumber;
    private String bio;

    public NewUserEvent(String username, String password, String name, String birthday, String email, String phoneNumber, String bio) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }
}
