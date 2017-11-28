package br.com.ikoa.twitterfeelings.main;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.ikoa.twitterfeelings.R;

public class MainActivity extends AppCompatActivity implements MainView {

    /**
     * Movies list adapter.
     */
    private MainAdapter adapter;

    /**
     * Represents the UI elements.
     */
    private UI ui;

    /**
     * Represents the Activity presenter.
     */
    private MainPresenter mainPresenter;

    /**
     * RecyclerView layout manager.
     */
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        ui = new UI();
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);

        SearchView searchView = (SearchView) MenuItemCompat
                .getActionView(menu.findItem(R.id.main_activity_menu_search));

        ui.setSearchView(searchView);

        return true;
    }

    @Override
    public void toLoadingState() {
        ui.toLoadingState();
    }

    @Override
    public void toNormalState() {
        ui.toNormalState();
    }

    @Override
    public void toErrorState() {
        if (ui.recyclerView.getVisibility() == View.VISIBLE) {
            ui.toNormalState();
        } else {
            ui.toErrorState();
        }
    }

    @Override
    public void setItems(List<TweetBean> tweets) {
        adapter.setTweets(tweets);
    }

    /**
     * UI class.
     */
    private class UI {

        /**
         * Loading view.
         */
        private final ProgressBar loading;

        /**
         * RecyclerView.
         */
        private final RecyclerView recyclerView;

        /**
         * Error view.
         */
        private final TextView errorView;

        /**
         * Image view.
         */
        private final ImageView image;

        /**
         * Search view.
         */
        private SearchView searchView;

        /**
         * Constructor.
         */
        private UI() {
            loading = (ProgressBar) findViewById(R.id.main_activity_loading);
            recyclerView = (RecyclerView) findViewById(R.id.main_activity_list);
            errorView = (TextView) findViewById(R.id.main_activity_error_text);
            image = (ImageView) findViewById(R.id.main_activity_image);

            setupUI();
        }

        /**
         * Configure layouts.
         */
        private void setupUI() {
            recyclerView.setLayoutManager(layoutManager);
            adapter = new MainAdapter();
            recyclerView.setAdapter(adapter);
        }

        /**
         * Change the layout to loading state.
         */
        private void toLoadingState() {
            loading.setVisibility(View.VISIBLE);
            errorView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        }

        /**
         * Change the layout to normal state.
         */
        private void toNormalState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }

        /**
         * Change the layout to error state.
         */
        private void toErrorState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        }

        /**
         * Keep and configure the search view.
         *
         * @param view
         *         Search view.
         */
        private void setSearchView(SearchView view) {
            searchView = view;
            searchView.setMaxWidth(Integer.MAX_VALUE);


            if (searchView != null) {
                searchView.setQueryHint(getString(R.string.menu_search_hint));
                searchView.setOnQueryTextListener(new SearchTextListener());
            }
        }

        /**
         * Remove the focus from search view.
         */
        private void clearSearchViewFocus() {
            searchView.clearFocus();
        }
    }

    /**
     * Search view listener.
     */
    private class SearchTextListener implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            mainPresenter.onSearch(query);
            ui.clearSearchViewFocus();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }
}
