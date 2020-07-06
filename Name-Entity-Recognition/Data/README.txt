To create a wordlist of words belonging to a specific cathegory follow the instruction in the following repo:
https://github.com/MLjungg/gazetteer

The next step is to download and parse data that you want to train your NER model on. You can find various types of data from https://spraakbanken.gu.se/resurser. Choose a source and download the XML-file and parse it using the XML-parser found in this repo. 

You will now have words labeled with the POS-tags PM, NN, JJ. 

The next step is using the gazetteers and run over this document to substitute the POS-tag with the correct cathegory. You can find my data in the file "dataFile_train.txt".
