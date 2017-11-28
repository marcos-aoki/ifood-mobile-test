package br.com.ikoa.twitterfeelings.main;

import android.view.View;

/**
 * Tweet view presenter interface.
 */
interface TweetViewPresenter {

    /**
     * Called when a tweet is clicked.
     *
     * @param view Tweet view.
     * @param text Tweet text.
     */
    void onClick(View view, String text);
}
