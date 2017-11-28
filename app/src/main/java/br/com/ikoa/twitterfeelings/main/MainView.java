package br.com.ikoa.twitterfeelings.main;

import java.util.List;

/**
 * Called when need to change the UI state.
 */
interface MainView {

    /**
     * Change the layout to loading state.
     */
    void toLoadingState();

    /**
     * Change the layout to normal state.
     */
    void toNormalState();

    /**
     * Change the layout to error state.
     */
    void toErrorState();

    /**
     * Set the items on the list.
     *
     * @param tweets List items.
     */
    void setItems(List<TweetBean> tweets);
}
