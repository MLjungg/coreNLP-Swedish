# Data

Follow these instruction to create a dataset that can be used to train a NER model.

First of all, start with creating a dictionary of words that belongs to a specific cathegory. You can follow the instruction I wrote in this repo: https://github.com/MLjungg/gazetteer.

The next step is to download and parse data that you want to train your NER model on. You can find various types of data from https://spraakbanken.gu.se/resurser. Choose a source and download the XML-file and parse it using the XML-parser found in this repo. 

You will now have words labeled with the POS-tags PM, NN, JJ. 

The next step is to use the gazetteers and substitute the POS-tag with the correct cathegory.

You're done! You can find my attempt to label data in the file "dataFile_train.txt".
