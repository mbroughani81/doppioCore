package doppio.apps.explorer.explorerpanel.listener;

import doppio.apps.post.controller.PostController;
import doppio.apps.post.model.Tweet;

import java.util.LinkedList;

public class ExplorerPanelListener  {
    PostController postController;

    public ExplorerPanelListener() {
        postController = new PostController();
    }

    public LinkedList<Tweet> getTweets() {
        return postController.getAllTweet();
    }
}
