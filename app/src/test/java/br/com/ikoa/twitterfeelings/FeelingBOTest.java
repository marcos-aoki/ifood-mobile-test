package br.com.ikoa.twitterfeelings;

import org.junit.Before;
import org.junit.Test;

import br.com.ikoa.twitterfeelings.feeling.FeelingBO;

import static org.junit.Assert.assertEquals;

public class FeelingBOTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_analyze_feeling_returns_happy() {
        FeelingBO.Feeling feeling = FeelingBO.analyzeFeeling(1);
        assertEquals(feeling, FeelingBO.Feeling.HAPPY);
    }

    @Test
    public void test_analyze_feeling_returns_neutral() {
        FeelingBO.Feeling feeling = FeelingBO.analyzeFeeling(0);
        assertEquals(feeling, FeelingBO.Feeling.NEUTRAL);
    }

    @Test
    public void test_analyze_feeling_returns_sad() {
        FeelingBO.Feeling feeling = FeelingBO.analyzeFeeling(-1);
        assertEquals(feeling, FeelingBO.Feeling.SAD);
    }

    @Test
    public void test_analyze_feeling_returns_invalid() {
        FeelingBO.Feeling feeling = FeelingBO.analyzeFeeling(10);
        assertEquals(feeling, FeelingBO.Feeling.INVALID);
    }
}
