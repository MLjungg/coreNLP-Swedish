package customAnnotators.GDPR;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.List;

public class GdprToken {
    private boolean gdprSensitive = false;
    public List<CoreLabel> prohibited_tokens = new ArrayList<CoreLabel>();

    GdprToken(){
    }

    public boolean isGdprSensitive() {
        return gdprSensitive;
    }

    private void setGdprSensitive() {
        this.gdprSensitive = true;
    }

    public List<CoreLabel> getProhibited_tokens() {
        return prohibited_tokens;
    }

    private void addProhibitedToken(CoreLabel prohibited_token) {
        this.prohibited_tokens.add(prohibited_token);
    }

    void verifyGdprCompliance(List<CoreMap> sentences){
        boolean containsName = false;
        boolean containsVerb = false;
        boolean containsPolitics = false;
        for (CoreMap sentence : sentences){
            List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            for (CoreLabel token:tokens) {
                if (token.ner().equals("PER")){
                    containsName = true;
                    addProhibitedToken(token);
                }
                if (token.ner().equals("POLITICS")){
                    containsPolitics = true;
                    addProhibitedToken(token);
                }
                String pos_tag = token.get(CoreAnnotations.PartOfSpeechAnnotation.class).split("\\|")[0];
                if (pos_tag.equals("VB")){
                    containsVerb = true;
                }
            }
        }
        if (containsName && containsVerb && containsPolitics){
            setGdprSensitive();
        }
        else{
            prohibited_tokens.clear();
        }
    }
}
