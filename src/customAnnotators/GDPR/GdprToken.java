package customAnnotators.GDPR;

import edu.stanford.nlp.ling.CoreLabel;

import java.util.ArrayList;
import java.util.List;

public class GdprToken {
    boolean gdprSensitive = false;
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

    void verifyGdprCompliance(List<CoreLabel> tokens){
        for (CoreLabel token : tokens){
            if (token.ner().equals("PER")){
                setGdprSensitive();
                addProhibitedToken(token);
            }
        }
    }
}
