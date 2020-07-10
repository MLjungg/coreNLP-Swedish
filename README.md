# coreNLP-Swedish

This is a repository where I have explored the library coreNLP and how it can be used to annotate, tag and understand Swedish text.

For now, a first version of the following annotators have been created:
- Part of Speech (POS)
- Lemma
- Dependency Parser (ddepars)
- Name Entity Recognition (NER)

The models, the corresponding evaluation metrics and how they were trained can be found in respective directory.

Regarding Tokenization (tok) and wordToSentence (ssplit), it is suitable to use the english models. Since the swedish and english language is structurally alike, these annotators perform well in both languages.

----------------------------------------------

In the folder src you will find code were the annotators above are imported to coreNLP and used to form a custom annotators.
