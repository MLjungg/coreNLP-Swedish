package customAnnotators.sentiment;

import edu.stanford.nlp.ling.CoreAnnotation;


public class SentimentAnnotation implements CoreAnnotation<SentimentToken> {
    public SentimentAnnotation() {
    }

    @Override
    public Class<SentimentToken> getType() { return SentimentToken.class; }
}
