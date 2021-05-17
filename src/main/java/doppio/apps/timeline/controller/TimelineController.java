package doppio.apps.timeline.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.sociallist.model.BlockList;
import doppio.apps.timeline.model.LikedTweetList;
import doppio.apps.timeline.model.MutedUserList;
import doppio.controller.AbstractController;
import doppio.event.AddToBlockedEvent;
import doppio.event.AddToMutedEvent;
import doppio.event.NewLikeEvent;

public class TimelineController extends AbstractController {

    public void newLike(NewLikeEvent event) {
        User u = context.Users.get(event.getUserId());
        LikedTweetList likedTweetList = context.LikedTweetLists.get(u.getLikedTweetListId());
        if (likedTweetList.getTweetIds().contains(event.getTweetId()))
            return;
        likedTweetList.getTweetIds().add(event.getTweetId());
        context.LikedTweetLists.update(likedTweetList);
    }

    public void addToMuted(AddToMutedEvent event) {
        User u1 = context.Users.get(event.getMuterId());
        MutedUserList mutedUserList = context.MutedUserLists.get(u1.getMutedUserListId());
        if (mutedUserList.getUserIds().contains(event.getMutedId()))
            return;
        mutedUserList.getUserIds().add(event.getMutedId());
        context.MutedUserLists.update(mutedUserList);
    }

    public void clearDB() {
        context.LikedTweetLists.clear();
        context.MutedUserLists.clear();
        context.ReportedTweetLists.clear();
    }
}
