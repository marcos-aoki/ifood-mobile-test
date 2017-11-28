package br.com.ikoa.twitterfeelings.feeling;

/**
 * Tweet request content information.
 */
public class FeelingRequestContentBean {

    /**
     * Text type.
     */
    private String type;

    /**
     * Text content.
     */
    private String content;

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
