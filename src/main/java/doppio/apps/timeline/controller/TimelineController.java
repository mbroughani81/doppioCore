package doppio.apps.timeline.controller;

import doppio.controller.AbstractController;

public class TimelineController extends AbstractController {
    public void clearDB() {
        context.LikedTweetLists.clear();
        context.MutedUserLists.clear();
        context.ReportedTweetLists.clear();
    }
}
