package doppio.apps.authentication.controller;

import doppio.apps.authentication.model.Profile;
import doppio.apps.authentication.model.User;
import doppio.apps.messenger.model.MessageData;
import doppio.apps.messenger.model.Chat;
import doppio.apps.post.model.Tweet;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;
import doppio.apps.sociallist.model.NotificationBox;
import doppio.apps.timeline.model.LikedTweetList;
import doppio.apps.timeline.model.MutedUserList;
import doppio.apps.timeline.model.ReportedTweetList;
import doppio.controller.AbstractController;
import doppio.event.*;

public class AuthController extends AbstractController {

    public void addUser(NewUserEvent event) {
        Profile profile = new Profile(event.getName(), event.getBirthday(), event.getEmail(), event.getPhoneNumber(), event.getBio());
        BlockList blockList = new BlockList();
        FollowerList followerList = new FollowerList();
        FollowingList followingList = new FollowingList();
        MessageData messageData = new MessageData();
        NotificationBox notificationBox = new NotificationBox();
        LikedTweetList likedTweetList = new LikedTweetList();
        ReportedTweetList reportedTweetList = new ReportedTweetList();
        MutedUserList mutedUserList = new MutedUserList();
        int id1 = context.Blocklists.add(blockList);
        int id2 = context.FollowerLists.add(followerList);
        int id3 = context.FollowingLists.add(followingList);
        int id4 = context.MessageDatas.add(messageData);
        int id5 = context.NotificationBoxes.add(notificationBox);
        int id6 = context.LikedTweetLists.add(likedTweetList);
        int id7 = context.ReportedTweetLists.add(reportedTweetList);
        int id8 = context.MutedUserLists.add(mutedUserList);
        User user = new User(profile, event.getUsername(), event.getPassword(), id1, id2, id3, id4, id5, id6, id7, id8);
        context.Profiles.add(profile);
        context.Users.add(user);
    }

    public User getUser(String username) {
        for (User user : context.Users.all()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public User getUser(int userId) {
        return context.Users.get(userId);
    }

    public void deleteUser(User user) {
        // delete from blocklist, followerlists, followinglists
        for (BlockList blockList : context.Blocklists.all()) {
            blockList.getList().remove((Object)user.getId());
            context.Blocklists.update(blockList);
        }
        for (FollowerList followerList : context.FollowerLists.all()) {
            followerList.getList().remove((Object)user.getId());
            context.FollowerLists.update(followerList);
        }
        for (FollowingList followingList : context.FollowingLists.all()) {
            followingList.getList().remove((Object)user.getId());
            context.FollowingLists.update(followingList);
        }
        // delete the user blocklist, followerlist, followinglist
        context.Blocklists.remove(user.getBlockListId());
        context.FollowingLists.remove(user.getFollowingListId());
        context.FollowerLists.remove(user.getFollowersListId());
        // delete the user groupchats, messagedatas, privatechats
        MessageData messageData = context.MessageDatas.get(user.getMessageDataId());
        for (int privateChatId : messageData.getChatIds()) {
            context.Chats.remove(privateChatId);
        }
        context.MessageDatas.remove(messageData.getId());
        // delete the user profile and user
        System.out.println(user.getId() + " auth controller in deleteuser");
        context.Profiles.remove(user.getProfile().getId());
        context.Users.remove(user.getId());
        // make a new ghostuser and assign the tweet, privatechats, (messagedatas), groupchats to that id
        User ghostUser = new User(null, "ghostuser", "ghostpass", -1, -1, -1, -1, -1, -1, -1, -1);
        int ghostUserId = context.Users.add(ghostUser);
        ghostUser.setId(ghostUserId);
        for (Tweet tweet : context.Tweets.all()) {
            if (tweet.getCreator().getId() == user.getId()) {
                tweet.setCreator(ghostUser);
                context.Tweets.update(tweet);
            }
        }
        for (Chat chat : context.Chats.all()) {
            for (int i = 0; i < chat.getMemberIds().size(); i++) {
                if (chat.getMemberIds().get(i) == user.getId())
                    chat.getMemberIds().set(i, ghostUserId);
            }
            context.Chats.update(chat);
        }
    }

    public Profile getProfile(int profileId) {
        return context.Profiles.get(profileId);
    }

    public void changePrivacy(ChangePrivacyEvent event) {
        Profile p = event.getProfile();
        p.setPrivacy(event.getNewPrivacy());
        context.Profiles.update(p);
    }

    public void changeLastSeenPrivacy(ChangeLastSeenPrivacy event) {
        Profile p = event.getProfile();
        p.setLastSeenPrivacy(event.getNewPrivacy());
        context.Profiles.update(p);
    }


    public void changeName(NewNameEvent event) {
        User user = context.Users.get(event.getUser().getId());
        Profile profile = context.Profiles.get(user.getProfile().getId());
        profile.setName(event.getNewName());
        context.Profiles.update(profile);
    }

    public void changeBirthday(NewBirthdayEvent event) {
        User user = context.Users.get(event.getUser().getId());
        Profile profile = context.Profiles.get(user.getProfile().getId());
        profile.setBirthday(event.getNewBirthday());
        context.Profiles.update(profile);
    }

    public void changeEmail(NewEmailEvent event) {
        User user = context.Users.get(event.getUser().getId());
        Profile profile = context.Profiles.get(user.getProfile().getId());
        profile.setEmail(event.getNewEmail());
        context.Profiles.update(profile);
    }

    public void changePhonenumber(NewPhonenumberEvent event) {
        User user = context.Users.get(event.getUser().getId());
        Profile profile = context.Profiles.get(user.getProfile().getId());
        profile.setPhoneNumber(event.getNewPhonenumber());
        context.Profiles.update(profile);
    }

    public void changeBio(NewBioEvent event) {
        User user = context.Users.get(event.getUser().getId());
        Profile profile = context.Profiles.get(user.getProfile().getId());
        profile.setBio(event.getNewBio());
        context.Profiles.update(profile);
    }

    public void deactivateUser(User user) {
        user.setActive(false);
        context.Users.update(user);
    }

    public boolean usernameExists(String username) {
        for (User user : context.Users.all()) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean passwordMatches(String username, String password) {
        for (User user : context.Users.all()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void clearProfileDB() {
        context.Profiles.clear();
    }

    public void clearUserDB() {
        context.Users.clear();
    }
}
