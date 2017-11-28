package br.com.ikoa.twitterfeelings.main;

import android.content.Intent;
import android.view.View;

import br.com.ikoa.twitterfeelings.feeling.FeelingActivity;
import br.com.ikoa.twitterfeelings.util.Constants;

/**
 * Tweet view presenter implementation.
 */
public class TweetViewPresenterImpl implements TweetViewPresenter {

    @Override
    public void onClick(View view, String text) {
        Intent intent = new Intent(view.getContext(), FeelingActivity.class);
        intent.putExtra(Constants.TEXT_INTENT_EXTRA, text);
        view.getContext().startActivity(intent);
    }
}
