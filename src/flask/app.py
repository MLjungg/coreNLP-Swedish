from flask import Flask, request, jsonify
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
import json

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

def analyze_sentiment(text):
    analyzer = SentimentIntensityAnalyzer()
    score = analyzer.polarity_scores(text)
    sentence_rating = score["compound"]
    word_ratings = {}
    for word, sentiment in score["debug"]:
        word_ratings[word] = sentiment

    return sentence_rating, word_ratings

@app.route('/sentimentAnnotator/', methods=["POST"])
def post_sentiment():
    decoded_data = request.data.decode('utf-8')
    params = json.loads(decoded_data)

    body = params["text"]
    sentence_rating, word_ratings = analyze_sentiment(body)

    print(params)
    return jsonify({'sentence_rating': sentence_rating, 'word_ratings': word_ratings})

if __name__ == '__main__':
    app.run()
