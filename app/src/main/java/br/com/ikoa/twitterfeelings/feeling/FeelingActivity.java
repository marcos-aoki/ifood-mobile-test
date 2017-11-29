package br.com.ikoa.twitterfeelings.feeling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.ikoa.twitterfeelings.R;

/**
 * Feeling activity.
 */
public class FeelingActivity extends AppCompatActivity implements FeelingView {

    /**
     * Represents the UI elements.
     */
    private UI ui;

    /**
     * Represents the Activity presenter.
     */
    private FeelingPresenter feelingPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeling_activity);

        ui = new UI();
        feelingPresenter = new FeelingPresenterImpl(this);
        feelingPresenter.onCreate(getIntent());
    }

    @Override
    public void toLoadingState() {
        ui.toLoadingState();
    }

    @Override
    public void toErrorState() {
        ui.toErrorState();
    }

    @Override
    public void toHappyState() {
        ui.toHappyState();
    }

    @Override
    public void toNeutralState() {
        ui.toNeutralState();
    }

    @Override
    public void toSadState() {
        ui.toSadState();
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
         * Error view.
         */
        private final View errorView;

        /**
         * Image view.
         */
        private final ImageView image;

        /**
         * View container.
         */
        private final View container;

        /**
         * Constructor.
         */
        private UI() {
            loading = (ProgressBar) findViewById(R.id.feeling_activity_loading);
            errorView = findViewById(R.id.feeling_activity_error_container);
            image = (ImageView) findViewById(R.id.feeling_activity_image);
            container = findViewById(R.id.feeling_activity_container);
        }

        /**
         * Change the layout to loading state.
         */
        private void toLoadingState() {
            loading.setVisibility(View.VISIBLE);
            errorView.setVisibility(View.GONE);
        }

        /**
         * Change the layout to error state.
         */
        private void toErrorState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.VISIBLE);
        }

        /**
         * Change the layout to happy state.
         */
        private void toHappyState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
            image.setImageResource(R.drawable.ic_happy);
            image.animate().rotation(360).setDuration(1000);
            container.setBackgroundColor(getResources().getColor(R.color.happy));
        }

        /**
         * Change the layout to neutral state.
         */
        private void toNeutralState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
            image.setImageResource(R.drawable.ic_neutral);
            image.animate().rotation(360).setDuration(1000);
            container.setBackgroundColor(getResources().getColor(R.color.neutral));
        }

        /**
         * Change the layout to sad state.
         */
        private void toSadState() {
            loading.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
            image.setImageResource(R.drawable.ic_sad);
            image.animate().rotation(360).setDuration(1000);
            container.setBackgroundColor(getResources().getColor(R.color.sad));
        }
    }
}
