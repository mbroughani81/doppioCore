package doppio.apps.sociallist.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;
import doppio.controller.AbstractController;
import doppio.event.AddToBlockedEvent;
import doppio.event.AddToFollowerEvent;

import java.util.LinkedList;

public class SocialListController extends AbstractController {
    public void addToBlocked(AddToBlockedEvent event) {
        BlockList blockList = context.Blocklists.get(event.getBlocker().getBlockListId());
        blockList.getList().add(event.getBlocked().getId());
        context.Blocklists.update(blockList);
    }

    public void addToFollower(AddToFollowerEvent event) {
        FollowerList followerList = context.FollowerLists.get(event.getFollowd().getFollowersListId());
        followerList.getList().add(event.getFollower().getId());
        FollowingList followingList = context.FollowingLists.get(event.getFollower().getFollowingListId());
        followingList.getList().add(event.getFollowd().getId());
        context.FollowingLists.update(followingList);
        context.FollowerLists.update(followerList);
    }

    public FollowingList getFollowingList(User user) {
        return context.FollowingLists.get(user.getFollowingListId());
    }

    public FollowerList getFollowersList(User user) {
        return context.FollowerLists.get(user.getFollowersListId());
    }

    public BlockList getBlocked(User user) {
        return context.Blocklists.get(user.getBlockListId());
    }

    public void clearBlackListDB() {
        context.Blocklists.clear();
    }
    public void clearFollowingListDB() {
        context.FollowingLists.clear();
    }
    public void clearFollowerListDB() {
        context.FollowerLists.clear();
    }
}
