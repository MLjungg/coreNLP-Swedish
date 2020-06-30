# POS-Tagger

This is a POS-tagger in swedish. The model was trained using data from talbanken (https://universaldependencies.org/treebanks/sv_talbanken/index.html).

To train the model use the following command:
java -classpath /PATH/TO/stanford-postagger-4.0.0.jar edu.stanford.nlp.tagger.maxent.MaxentTagger -prop /PATH/TO/swedish-pos-tagger-model.props

The properties in swedish-pos-tagger-model.props can be altered to improve the training/creation of the model. You also have to add the path to your training data in this file.

NOTE:
In order to use the data from talbanken you need to remove the comments that come along. coreNLP's training schedule expects pure data in each line. 
