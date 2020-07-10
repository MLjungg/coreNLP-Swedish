import customAnnotators.GDPR.GdprAnnotation;
import customAnnotators.GDPR.GdprToken;
import customAnnotators.sentiment.SentimentAnnotation;
import customAnnotators.sentiment.SentimentToken;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import java.util.List;


class SwedishPipeLine {

    static String main(String text) {

        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        StanfordCoreNLP pipeline = new StanfordCoreNLP(PropertiesUtils.asProperties(
                "annotators", "tokenize, ssplit, tokenize, ssplit, pos, customLemmaAnnotator, ner, depparse, GdprAnnotator, SentimentAnnotator",
                "pos.model", "/Users/mikael/stanford-corenlp-4.0.0/Stanford-POS/swedish-pos-tagger-model",
                "ner.model", "/Users/mikael/Documents/Programmeringsprojekt/coreNLP-Swedish/Name-Entity-Recognition/classifiers/health_politics_model.ser.gz,/Users/mikael/Documents/Programmeringsprojekt/coreNLP-Swedish/Name-Entity-Recognition/classifiers/pers_loc_org.ser",
                "ner.combinationMode", "HIGH_RECALL",
                "ner.useSUTime", "false",
                "ner.applyFineGrained", "false",
                "customAnnotatorClass.customLemmaAnnotator","customAnnotators.CustomLemmaAnnotator",
                "custom.lemma.lemmaFile", "/Users/Mikael/stanford-corenlp-4.0.0/lemma/lemmaFile.txt",
                "depparse.model", "/Users/Mikael/stanford-corenlp-4.0.0/Stanford-dependency-parser/swedish.nndep.model.txt.gz",
                "customAnnotatorClass.GdprAnnotator", "customAnnotators.GDPR.GdprAnnotator",
                "customAnnotatorClass.SentimentAnnotator", "customAnnotators.sentiment.SentimentAnnotator",
                "tokenize.language", "en"));

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        // Extract and iterate over sentences in text
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // Information that can be extracted from a word
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                System.out.println(word + "\t" + ne + "\t" + pos + "\t" + lemma + "\n");

            }
            // Information that can be extracted from a sentece
            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
            System.out.println(dependencies);

        }
        // Information that can be extraced from the text as a whole
        GdprToken gdprToken = document.get(GdprAnnotation.class);

        // Anonymize the text
        if(gdprToken.isGdprSensitive()){
            Anonymizer anonymizer = new Anonymizer(text);
            text = anonymizer.anonymizeText(gdprToken.prohibited_tokens);
        }

        return text;
    }
}
