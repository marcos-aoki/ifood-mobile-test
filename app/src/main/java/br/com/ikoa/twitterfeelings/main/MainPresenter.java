package br.com.ikoa.twitterfeelings.main;

/**
 * Main Activity presenter interface.
 */
interface MainPresenter {

    /**
     * Called when a search is done.
     *
     * @param userName The userName to find.
     */
    void onSearch(String userName);
}
