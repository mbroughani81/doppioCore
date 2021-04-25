package doppio.db;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;

public class Context {
    public DBSet<Tweet> Tweets = new TweetDB();
    public DBSet<User> Users = new UserDB();
    public DBSet<Profile> Profiles = new ProfileDB();
    public DBSet<BlockList> Blocklists = new BlockListDB();
    public DBSet<FollowingList> FollowingLists = new FollowingListDB();
    public DBSet<FollowerList> FollowerLists = new FollowerListDB();

}
