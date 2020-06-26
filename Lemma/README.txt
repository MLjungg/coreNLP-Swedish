This is a custom Lemma annotator - It maps words to its lemma form in Swedish:

Sämst --> Dålig
Bäst --> Bra
Beskattas --> Beskatta

This first version is fundamentally built using a {word, lemma} dictionary. The data originates from talbanken, where I have added the datasets train, dev, test together and parsed it to a suitable format. The dataset can be found here:

https://github.com/UniversalDependencies/UD_Swedish-Talbanken

In a future version, it can be valuable to consider the part of speech to improve the annotator. 