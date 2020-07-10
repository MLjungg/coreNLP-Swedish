package customAnnotators.sentiment;

import com.google.gson.JsonObject;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;
import edu.stanford.nlp.util.ArraySet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class SentimentAnnotator implements Annotator {
    private Requester requester = new Requester();

    @Override
    public void annotate(Annotation annotation) {
        String text = annotation.get(CoreAnnotations.TextAnnotation.class);
        JsonObject data = null;
        try {
            data = requester.post_sentiment(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        float sentence_rating = Objects.requireNonNull(data).get("sentence_rating").getAsFloat();
        JsonObject wordRatings = (JsonObject) data.get("word_ratings");

        SentimentToken sentenceSentimentToken = new SentimentToken(sentence_rating);
        annotation.set(SentimentAnnotation.class, sentenceSentimentToken);

        for (CoreLabel token : annotation.get(CoreAnnotations.TokensAnnotation.class)) {
            String word = token.get(CoreAnnotations.TextAnnotation.class);
            if (wordRatings.has(word)){
                token.set(SentimentAnnotation.class, new SentimentToken(wordRatings.get(word).getAsFloat()));
            }
            else{
                token.set(SentimentAnnotation.class, new SentimentToken(0));
            }
        }
    }

    @Override
    public Set<Class<? extends CoreAnnotation>> requirementsSatisfied() {
        return Collections.singleton(SentimentAnnotation.class);

    }

    @Override
    public Set<Class<? extends CoreAnnotation>> requires() {
        return Collections.unmodifiableSet(new ArraySet<>(Arrays.asList(
                CoreAnnotations.TextAnnotation.class,
                CoreAnnotations.TokensAnnotation.class,
                CoreAnnotations.SentencesAnnotation.class)
        ));
    }
}
