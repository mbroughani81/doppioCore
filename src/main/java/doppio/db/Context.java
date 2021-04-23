package doppio.db;

import doppio.authentication.model.Profile;
import doppio.authentication.model.User;

public class Context {
    public DBSet<User> Users = new UserDB();
    public DBSet<Profile> Profiles = new ProfileDB();
}
