package br.com.ikoa.twitterfeelings.feeling;

/**
 * Called when need to change the UI state.
 */
interface FeelingView {

    /**
     * Change the layout to loading state.
     */
    void toLoadingState();

    /**
     * Change the layout to error state.
     */
    void toErrorState();

    /**
     * Change the layout to happy state.
     */
    void toHappyState();

    /**
     * Change the layout to neutral state.
     */
    void toNeutralState();

    /**
     * Change the layout to sad state.
     */
    void toSadState();
}
