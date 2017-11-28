package br.com.ikoa.twitterfeelings.feeling;

import com.google.gson.annotations.SerializedName;

/**
 * Text feeling information.
 */
public class FeelingBean {

    /**
     * Text sentiment information.
     */
    @SerializedName("documentSentiment")
    private FeelingDocumentBean feelingDocumentBean;

    public FeelingDocumentBean getFeelingDocumentBean() {
        return feelingDocumentBean;
    }
}
