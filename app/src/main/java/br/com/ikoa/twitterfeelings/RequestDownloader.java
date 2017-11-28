package br.com.ikoa.twitterfeelings;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Abstract class to execute download request.
 *
 * @param <T> Object to parser.
 */
public abstract class RequestDownloader<T> {

    /**
     * Log tag.
     */
    private static final String LOG_TAG = RequestDownloader.class.getSimpleName();

    /**
     * Return the listener to support the request execution.
     *
     * @return the listener to support the request execution.
     */
    protected abstract RequestListener<T> getRequestListener();

    /**
     * Return the request URL.
     *
     * @return the request URL.
     */
    protected abstract String getUrl();

    /**
     * Return the type of object to parser.
     *
     * @return the type of object to parser.
     */
    protected abstract Type getType();

    /**
     * Return the request client.
     *
     * @return the request client.
     */
    protected OkHttpClient getRequestClient() {
        return new OkHttpClient.Builder().build();
    }

    /**
     * Return the request.
     *
     * @return the request.
     */
    protected Request getRequest() {
        return new Request.Builder().url(getUrl()).build();
    }

    /**
     * Listener to support the request execution.
     *
     * @param <T> Type of object to be parsed.
     */
    public interface RequestListener<T> {

        /**
         * Called on finish download.
         *
         * @param bean Parsed object.
         */
        void onFinishDownload(T bean);
    }

    /**
     * Execute the request download.
     */
    public class GetDataTask extends AsyncTask<Void, Void, T> {

        @Override
        protected T doInBackground(Void... params) {
            T bean = null;

            try {
                Response response = getRequestClient().newCall(getRequest()).execute();
                if (response.isSuccessful()) {
                    String json = response.body().string();

                    Gson gson = new Gson();
                    bean = gson.fromJson(json, getType());
                }

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error on execute request download: ", e);
            }

            return bean;
        }

        @Override
        protected void onPostExecute(T bean) {
            if (getRequestListener() != null) {
                getRequestListener().onFinishDownload(bean);
            }
        }
    }
}