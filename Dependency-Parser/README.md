# Dependency Parser

This is a swedish dependency parser trained using the following datasets:

- A dependency tree bank, can be found in the subdirectory "UD_Swedish-Talbanken-master". Use the cleaned version.
- A word embedding file, can be downloaded from here: http://vectors.nlpl.eu/repository/#

The documentation for the training process can be found here:
https://nlp.stanford.edu/software/nndep.shtml
 
Run the following command to train the model:
java -Xmx8g -classpath /PATH/TO/stanford-corenlp-4.0.0.jar edu.stanford.nlp.parser.nndep.DependencyParser -trainFile /PATH/TO/sv_cleaned_talbanken-ud-train.conllu -testFile /PATH/TO//sv_cleaned_talbanken-ud-test.conllu -embedFile /PATH/TO/model_embed.txt -embeddingSize 100 -model swedish.nndep.model.txt.gz

Evalutation:
UAS = 81,3613
LAS = 77,6316