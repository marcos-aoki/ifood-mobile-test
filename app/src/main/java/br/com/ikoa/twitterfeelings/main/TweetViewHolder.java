package br.com.ikoa.twitterfeelings.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.ikoa.twitterfeelings.R;

/**
 * Tweet item view holder.
 */
public class TweetViewHolder extends RecyclerView.ViewHolder {

    /**
     * Tweet text.
     */
    private final TextView text;

    /**
     * View container.
     */
    private final View container;

    /**
     * Tweet view presenter.
     */
    private final TweetViewPresenter presenter;

    /**
     * Constructor
     *
     * @param itemView Item view.
     */
    public TweetViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.tweet_item_text);
        container = itemView.findViewById(R.id.tweet_item_container);
        presenter = new TweetViewPresenterImpl();
    }

    /**
     * Bind data.
     *
     * @param tweet Tweet information.
     */
    public void bind(TweetBean tweet) {
        text.setText(tweet.getText());
        container.setOnClickListener(new ItemClick(tweet));
    }

    /**
     * Item click listener.
     */
    private class ItemClick implements View.OnClickListener {

        /**
         * Tweet information.
         */
        private final TweetBean tweet;

        /**
         * Constructor.
         *
         * @param tweet Tweet information.
         */
        ItemClick(TweetBean tweet) {
            this.tweet = tweet;
        }

        @Override
        public void onClick(View view) {
            presenter.onClick(view, tweet.getText());
        }
    }
}
