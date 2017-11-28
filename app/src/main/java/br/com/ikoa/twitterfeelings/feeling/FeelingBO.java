package br.com.ikoa.twitterfeelings.feeling;

/**
 * Feeling business class.
 */
public class FeelingBO {

    /**
     * Feeling types.
     */
    public enum Feeling {
        HAPPY, NEUTRAL, SAD;
    }

    /**
     * Happy score start range (between 0.25 ~ 1.0).
     */
    private static final float HAPPY_SCORE_START_RANGE = 0.25f;

    /**
     * Sad score start range (between -0.25 ~ -1.0).
     */
    private static final float SAD_SCORE_START_RANGE = -0.25f;

    /**
     * Analyze the text feeling.
     *
     * @param score Text feeling score.
     *
     * @return The feeling type.
     */
    public static Feeling analyzeFeeling(float score) {
        Feeling feeling;
        if (score > HAPPY_SCORE_START_RANGE) {
            feeling = Feeling.HAPPY;
        } else if (score < SAD_SCORE_START_RANGE) {
            feeling = Feeling.SAD;
        } else {
            feeling = Feeling.NEUTRAL;
        }
        return feeling;
    }
}
