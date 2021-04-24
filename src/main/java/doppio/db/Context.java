package doppio.db;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;

public class Context {
    public DBSet<User> Users = new UserDB();
    public DBSet<Profile> Profiles = new ProfileDB();
}
