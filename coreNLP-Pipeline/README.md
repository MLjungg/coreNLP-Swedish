# coreNLP annotation pipeline + custom annotators

This is a POC of how to set up the coreNLP annotation pipeline. It will load all the annotators found in the root directory together with custom GDPR and Lemma annotator found in the subdirectory customAnnotators in this folder.


The pipeline will return an anonymized version of the input text based on the rules defined in the GDPR annotator.
