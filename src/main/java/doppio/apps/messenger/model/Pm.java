package doppio.apps.messenger.model;

public class Pm {
    private int id;
    private int userId;
    private String text;

    public Pm(int userId) {
        this.id = -1;

        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
