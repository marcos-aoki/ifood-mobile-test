package br.com.ikoa.twitterfeelings.feeling;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import br.com.ikoa.twitterfeelings.RequestDownloader;
import br.com.ikoa.twitterfeelings.util.Constants;
import br.com.ikoa.twitterfeelings.util.URLConstants;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Responsible to analyze the text sentiment.
 */
public class FeelingAnalyzer extends RequestDownloader<FeelingBean> {

    /**
     * JSON media type.
     */
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * Text type.
     */
    private static final String TEXT_TYPE = "PLAIN_TEXT";

    /**
     * Text encoding type.
     */
    private static final String ENCODING_TYPE = "UTF8";

    /**
     * Text to be analyzed.
     */
    private String text;

    /**
     * Listener called when finish download.
     */
    private RequestListener<FeelingBean> listener;

    /**
     * Analyze the text.
     *
     * @param text        Text to be analyzed.
     * @param listener    Listener called when finish download.
     */
    public void analyzeText(String text, RequestListener<FeelingBean> listener) {
        this.text = text;
        this.listener = listener;
        new GetDataTask().execute();
    }

    @Override
    protected RequestListener<FeelingBean> getRequestListener() {
        return new TweetFeelingAnalizerCallback();
    }

    @Override
    protected String getUrl() {
        Uri uri = Uri.parse(URLConstants.ANALYZE_SENTIMENT_URL)
                .buildUpon()
                .appendQueryParameter(URLConstants.KEY_PARAM, Constants.KEY)
                .build();
        return uri.toString();
    }

    @Override
    protected Type getType() {
        return new TypeToken<FeelingBean>() {
        }.getType();
    }

    @Override
    protected Request getRequest() {
        FeelingRequestBean feelingRequestBean = new FeelingRequestBean();
        FeelingRequestContentBean feelingRequestContentBean = new FeelingRequestContentBean();
        feelingRequestContentBean.setType(TEXT_TYPE);
        feelingRequestContentBean.setContent(text);
        feelingRequestBean.setDocument(feelingRequestContentBean);
        feelingRequestBean.setEncodingType(ENCODING_TYPE);

        Gson gson = new Gson();

        RequestBody body = RequestBody.create(JSON, gson.toJson(feelingRequestBean));
        return new Request.Builder().url(getUrl()).post(body).build();
    }

    /**
     * Callback called when finish analyze the text.
     */
    private class TweetFeelingAnalizerCallback implements RequestListener<FeelingBean> {

        @Override
        public void onFinishDownload(FeelingBean feelingBean) {
            listener.onFinishDownload(feelingBean);
        }
    }
}
