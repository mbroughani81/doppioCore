package doppio.apps.authentication.model;

public class User {
    private int id;

    private Profile profile;
    private String username;
    private String password;
    private int blockListId;

    public User(Profile profile, String username, String password, int blockListId) {
        this.profile = profile;
        this.username = username;
        this.password = password;
        this.blockListId = blockListId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBlockListId() {
        return blockListId;
    }

    public void setBlockListId(int blockListId) {
        this.blockListId = blockListId;
    }
}