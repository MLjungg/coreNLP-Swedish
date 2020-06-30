package customAnnotators.GDPR;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.ArraySet;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

public class GdprAnnotator implements Annotator {

    public GdprAnnotator(String name, Properties props){
    }

    @Override
    public void annotate(Annotation annotation) {
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        GdprToken gdprToken = new GdprToken();

        for (CoreMap sentence : sentences) {
            List<CoreLabel> word_tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            gdprToken.verifyGdprCompliance(word_tokens);
        }

        annotation.set(GdprAnnotation.class, gdprToken);

    }

    @Override
    public Set<Class<? extends CoreAnnotation>> requirementsSatisfied() {
        return Collections.singleton(CoreAnnotations.SentencesAnnotation.class);
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
