package doppio.apps.explorer.view.component.tweetlist.listener;

public interface TweetClickInvoker {
    void setTweetClickListener(TweetClickListener listener);
    void checkTweetClickListener(int tweetId);
}
