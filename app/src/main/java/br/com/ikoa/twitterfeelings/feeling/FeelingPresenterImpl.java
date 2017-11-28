package br.com.ikoa.twitterfeelings.feeling;

import android.content.Intent;

import br.com.ikoa.twitterfeelings.RequestDownloader;
import br.com.ikoa.twitterfeelings.util.Constants;

/**
 * Feeling activity presenter implementation.
 */
public class FeelingPresenterImpl implements FeelingPresenter {

    /**
     * Called to change the UI state.
     */
    private final FeelingView feelingView;

    /**
     * Constructor
     *
     * @param feelingView Commands to change the UI state.
     */
    public FeelingPresenterImpl(FeelingView feelingView) {
        this.feelingView = feelingView;
    }

    @Override
    public void onCreate(Intent intent) {
        feelingView.toLoadingState();
        String text = intent.getStringExtra(Constants.TEXT_INTENT_EXTRA);
        new FeelingAnalyzer().analyzeText(text, new TextFeelingAnalyzerListener());
    }

    /**
     * Text feeling analyzer listener.
     */
    private class TextFeelingAnalyzerListener implements RequestDownloader.RequestListener<FeelingBean> {

        @Override
        public void onFinishDownload(FeelingBean bean) {
            if (bean != null && bean.getFeelingDocumentBean() != null) {
                FeelingBO.Feeling feeling = FeelingBO.analyzeFeeling(
                        bean.getFeelingDocumentBean().getScore());
                switch (feeling) {
                    case HAPPY:
                        feelingView.toHappyState();
                        break;
                    case SAD:
                        feelingView.toSadState();
                        break;
                    case NEUTRAL:
                        feelingView.toNeutralState();
                        break;
                    default:
                        feelingView.toErrorState();
                }
            } else {
                feelingView.toErrorState();
            }
        }
    }
}
