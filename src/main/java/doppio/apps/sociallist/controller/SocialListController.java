package doppio.apps.sociallist.controller;

import doppio.apps.sociallist.model.BlockList;
import doppio.apps.sociallist.model.FollowerList;
import doppio.apps.sociallist.model.FollowingList;
import doppio.controller.AbstractController;
import doppio.event.AddToBlockedEvent;
import doppio.event.AddToFollowerEvent;

public class SocialListController extends AbstractController {
    public void addToBlocked(AddToBlockedEvent event) {
        BlockList blockList = context.Blocklists.get(event.getBlocker().getBlockListId());
        blockList.getList().add(event.getBlocked().getId());
        context.Blocklists.update(blockList);
    }

    public void addToFollower(AddToFollowerEvent event) {
        FollowerList followerList = context.FollowerLists.get(event.getFollowd().getBlockListId());
        followerList.getList().add(event.getFollower().getId());
        FollowingList followingList = context.FollowingLists.get(event.getFollower().getBlockListId());
        followingList.getList().add(event.getFollowd().getId());
        context.FollowingLists.update(followingList);
        context.FollowerLists.update(followerList);
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
