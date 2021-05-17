package doppio.apps.timeline.controller;

import doppio.apps.authentication.model.User;
import doppio.apps.timeline.model.LikedTweetList;
import doppio.controller.AbstractController;
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

    public void clearDB() {
        context.LikedTweetLists.clear();
        context.MutedUserLists.clear();
        context.ReportedTweetLists.clear();
    }
}
