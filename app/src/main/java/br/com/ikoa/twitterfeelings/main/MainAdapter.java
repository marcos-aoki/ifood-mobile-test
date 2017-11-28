package br.com.ikoa.twitterfeelings.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.ikoa.twitterfeelings.R;

/**
 * Tweets list adapter.
 */
class MainAdapter extends RecyclerView.Adapter {

    /**
     * Tweets list.
     */
    private final List<TweetBean> tweets;

    /**
     * Constructor.
     */
    MainAdapter() {
        tweets = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_item, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TweetViewHolder viewHolder = (TweetViewHolder) holder;
        TweetBean tweet = tweets.get(position);

        viewHolder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    /**
     * Set the tweets list.
     *
     * @param tweets Tweets list.
     */
    void setTweets(List<TweetBean> tweets) {
        this.tweets.clear();
        this.tweets.addAll(tweets);
        notifyDataSetChanged();
    }
}
