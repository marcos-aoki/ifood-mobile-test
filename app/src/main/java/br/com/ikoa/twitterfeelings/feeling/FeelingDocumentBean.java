package br.com.ikoa.twitterfeelings.feeling;

import com.google.gson.annotations.SerializedName;

/**
 * Text sentiment information.
 */
public class FeelingDocumentBean {

    /**
     * Text sentimental magnitude.
     */
    @SerializedName("magnitude")
    private float magnitude;

    /**
     * Text sentimental score.
     */
    @SerializedName("score")
    private float score;

    public float getMagnitude() {
        return magnitude;
    }

    public float getScore() {
        return score;
    }
}
