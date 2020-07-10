package customAnnotators.GDPR;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.ArraySet;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

public class GdprAnnotator implements Annotator {

    public GdprAnnotator(String name, Properties props){
    }

    @Override
    // This annotator will annotate a document as GDPR sensitive if it contains a verb, a PERS entity and a POLITICS
    // entity. Given that the text is GDPR senstive it will store the PERS token and the POLITICS token in a list, which later
    // will be anonymized.
    public void annotate(Annotation annotation) {
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        GdprToken gdprToken = new GdprToken();

        gdprToken.verifyGdprCompliance(sentences);

        annotation.set(GdprAnnotation.class, gdprToken);

    }

    @Override
    public Set<Class<? extends CoreAnnotation>> requirementsSatisfied() {
        return Collections.singleton(GdprAnnotation.class);
    }

    @Override
    public Set<Class<? extends CoreAnnotation>> requires() {
        return Collections.unmodifiableSet(new ArraySet<>(Arrays.asList(
                CoreAnnotations.TextAnnotation.class,
                CoreAnnotations.TokensAnnotation.class,
                CoreAnnotations.SentencesAnnotation.class,
                CoreAnnotations.NamedEntityTagAnnotation.class)
        ));
    }
}
