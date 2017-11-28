package br.com.ikoa.twitterfeelings.main;

import com.google.gson.annotations.SerializedName;

/**
 * Tweet information.
 */
public class TweetBean {

    /**
     * Tweet text.
     */
    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }
}
