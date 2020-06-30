import edu.stanford.nlp.ling.CoreLabel;

import java.util.List;

class Anonymizer {
    String text;
    private char anonymized_tag = 'X';

    Anonymizer(String text) {
        this.text = text;
    }

    String anonymizeText(List<CoreLabel> prohibited_tokens){
        StringBuilder anonymizedText = new StringBuilder(text);
        for (CoreLabel token : prohibited_tokens){
            int startChar = token.beginPosition();
            int endChar = token.endPosition();
            for (int i = startChar; i < endChar; i++) {
                anonymizedText.setCharAt(i, anonymized_tag);
            }
        }
        return anonymizedText.toString();
    }
}
