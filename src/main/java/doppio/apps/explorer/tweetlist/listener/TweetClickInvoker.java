package doppio.apps.explorer.tweetlist.listener;

public interface TweetClickInvoker {
    void setTweetClickListener(TweetClickListener listener);
    void checkTweetClickListener(int tweetId);
}
