package br.com.ikoa.twitterfeelings.main;

import android.net.Uri;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import br.com.ikoa.twitterfeelings.RequestDownloader;
import br.com.ikoa.twitterfeelings.util.Constants;
import br.com.ikoa.twitterfeelings.util.URLConstants;
import okhttp3.OkHttpClient;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Responsible to download the tweets list.
 */
public class TweetsDownloader extends RequestDownloader<TweetBean[]> {

    /**
     * Username to find.
     */
    private String userName;

    /**
     * Listener called when finish download.
     */
    private RequestListener<TweetBean[]> listener;

    /**
     * Download the tweets list.
     *
     * @param userName    Username to find.
     * @param listener    Listener called when finish download.
     */
    public void getTweets(String userName, RequestListener<TweetBean[]> listener) {
        this.userName = userName;
        this.listener = listener;
        new GetDataTask().execute();
    }

    @Override
    protected RequestListener<TweetBean[]> getRequestListener() {
        return new TweetsCallback();
    }

    @Override
    protected String getUrl() {
        Uri uri = Uri.parse(URLConstants.USER_TIMELINE_URL)
                .buildUpon()
                .appendQueryParameter(URLConstants.SCREEN_NAME_PARAM, userName)
                .build();
        return uri.toString();
    }

    @Override
    protected Type getType() {
        return new TypeToken<TweetBean[]>() {
        }.getType();
    }

    @Override
    protected OkHttpClient getRequestClient() {
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.CONSUMER_KEY,
                Constants.CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.TOKEN, Constants.TOKEN_SECRET);

        return new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();
    }

    /**
     * Callback called when finish download the tweets list.
     */
    private class TweetsCallback implements RequestDownloader.RequestListener<TweetBean[]> {

        @Override
        public void onFinishDownload(TweetBean[] tweets) {
            listener.onFinishDownload(tweets);
        }
    }
}
