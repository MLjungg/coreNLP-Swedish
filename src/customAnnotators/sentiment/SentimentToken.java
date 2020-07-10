package customAnnotators.sentiment;

public class SentimentToken {
    private float rating;
    private String sentiment;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    SentimentToken(float rating) {
        this.rating = rating;
        setSentiment();
    }

    void setSentiment(){
        if (this.rating > 0.05){
            sentiment = "Positive";
        }
        else if (this.rating < -0.05 ){
            sentiment = "Negative";
        }
        else{
            sentiment = "Neutral";
        }

    }
}