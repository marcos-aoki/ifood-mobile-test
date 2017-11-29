package br.com.ikoa.twitterfeelings.feeling;

/**
 * Feeling business class.
 */
public class FeelingBO {

    /**
     * Feeling types.
     */
    public enum Feeling {
        HAPPY, NEUTRAL, SAD, INVALID;
    }

    /**
     * Happy score start range.
     */
    private static final float HAPPY_SCORE_START_RANGE = 0.25f;

    /**
     * Happy score end range.
     */
    private static final float HAPPY_SCORE_END_RANGE = 1.0f;

    /**
     * Sad score start range.
     */
    private static final float SAD_SCORE_START_RANGE = -0.25f;

    /**
     * Sad score start range.
     */
    private static final float SAD_SCORE_END_RANGE = -1.0f;

    /**
     * Analyze the text feeling.
     *
     * @param score Text feeling score.
     *
     * @return The feeling type.
     */
    public static Feeling analyzeFeeling(float score) {
        Feeling feeling;

        if (score > HAPPY_SCORE_END_RANGE || score < SAD_SCORE_END_RANGE) {
            feeling = Feeling.INVALID;
        } else if (score >= HAPPY_SCORE_START_RANGE && score <= HAPPY_SCORE_END_RANGE) {
            feeling = Feeling.HAPPY;
        } else if (score <= SAD_SCORE_START_RANGE && score >= SAD_SCORE_END_RANGE) {
            feeling = Feeling.SAD;
        } else {
            feeling = Feeling.NEUTRAL;
        }
        return feeling;
    }
}
