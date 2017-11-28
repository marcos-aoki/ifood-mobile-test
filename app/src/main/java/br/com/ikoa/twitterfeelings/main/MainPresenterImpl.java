package br.com.ikoa.twitterfeelings.main;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.ikoa.twitterfeelings.RequestDownloader;

/**
 * Main activity presenter implementation.
 */
class MainPresenterImpl implements MainPresenter {

    /**
     * Called to change the UI state.
     */
    private final MainView mainView;

    /**
     * Responsible to download the tweets.
     */
    private final TweetsDownloader tweetsDownloader;

    /**
     * Listener called when finish download the popular movies list.
     */
    private final TweetsCallback tweetsCallback;

    /**
     * Constructor.
     *
     * @param mainView Commands to change the UI state.
     */
    MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        tweetsDownloader = new TweetsDownloader();
        tweetsCallback = new TweetsCallback();
    }

    @Override
    public void onSearch(String userName) {
        mainView.toLoadingState();
        tweetsDownloader.getTweets(userName, tweetsCallback);
    }

    /**
     * Listener called when finish download the tweets list.
     */
    private class TweetsCallback implements RequestDownloader.RequestListener<TweetBean[]> {

        @Override
        public void onFinishDownload(TweetBean[] tweets) {
            if (tweets != null && tweets.length > 0) {
                mainView.setItems(new ArrayList<>(Arrays.asList(tweets)));
                mainView.toNormalState();
            } else {
                mainView.toErrorState();
            }
        }
    }
}
