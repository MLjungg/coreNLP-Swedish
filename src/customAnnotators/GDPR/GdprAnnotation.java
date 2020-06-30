package customAnnotators.GDPR;

import edu.stanford.nlp.ling.CoreAnnotation;

public class GdprAnnotation implements CoreAnnotation<GdprToken> {
    public GdprAnnotation(){
    }

    @Override
    public Class<GdprToken> getType() {
        return GdprToken.class;
    }
}
