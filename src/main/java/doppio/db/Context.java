package doppio.db;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;

public class Context {
    public DBSet<Tweet> Tweets = new TweetDB();
    public DBSet<User> Users = new UserDB();
    public DBSet<Profile> Profiles = new ProfileDB();
}
