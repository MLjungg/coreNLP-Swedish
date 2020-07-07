# coreNLP annotation pipeline + custom annotators

This is a POC of how to set up the coreNLP annotation pipeline. It will load all the annotators found in the root directory, and the custom GDPR and Lemma annotator found in the subdirectory customAnnotators in this folder.

Based on the rules defined in the GDPR annotator, it will anonymize the input text and return the anonymized version.
