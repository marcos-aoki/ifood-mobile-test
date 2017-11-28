package br.com.ikoa.twitterfeelings.feeling;

/**
 * Feeling request information.
 */
public class FeelingRequestBean {

    /**
     * Feeling request content information.
     */
    private FeelingRequestContentBean document;

    /**
     * Text encoding type.
     */
    private String encodingType;

    public void setDocument(FeelingRequestContentBean document) {
        this.document = document;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }
}
