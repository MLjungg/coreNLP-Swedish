# Name Entity Recognition (NER)

This is a repository to train a NER classifier to annotate words about persons, locations, organisations, health and politics.

To train NER models for coreNLP you need the following:<br/>
- File with words and their corresponding label. This file can be found in the data directory.
- Properties file with information about the training process. You will also have to define where you have stored your training data in this file. Information about all the props can be found in the documentation: https://nlp.stanford.edu/nlp/javadoc/javanlp/edu/stanford/nlp/ie/NERFeatureFactory.html.

To train the model run the following command:<br/>
java -mx8g -cp stanford-ner.jar edu.stanford.nlp.ie.crf.CRFClassifier -prop PATH/TO/swedish-ner.prop

I managed to acheive the following F1-score on the train and test set:<br/>
LOC: 85.2%<br/>
ORG: 42.6%<br/>
PER: 82.3%<br/>
HEALTH: 88.5%<br/>
POLITICS: 85.3

