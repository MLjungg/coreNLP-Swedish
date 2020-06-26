# coreNLP-Swedish

This is a repository where I have explored the library coreNLP and how it can be used to annotate, tag and understand Swedish text.

For now, a first version of the following annotators have been created:
- Part of Speech (POS)
- Lemma
- Dependency Parser (ddepars)
- Name Entity Recognition (NER)

Regarding Tokenization (tok) and wordToSentence (ssplit), it is suitable to use the english models. Since the swedish and english language is structurally alike, these annotators perform well in both languages.

In respective folder is more information of how I created the models, along with how they perform on test data.
