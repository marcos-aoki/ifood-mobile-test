package br.com.ikoa.twitterfeelings.feeling;

import android.content.Intent;

/**
 * Feeling Activity presenter interface.
 */
interface FeelingPresenter {

    /**
     * Called when create the activity.
     *
     * @param intent Intent.
     */
    void onCreate(Intent intent);
}
