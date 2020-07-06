from bs4 import BeautifulSoup, Tag
import os, sys
import fileinput

PATH_TO_READ_DATA = "/Users/mikael/Desktop/webbnyheter2012.xml"
PATH_TO_WRITE_DATA = "output.txt"
f1 = open(PATH_TO_WRITE_DATA, "a")
sentence = []
train_sentence = []

doc = []
with open(PATH_TO_READ_DATA, "r") as f:
    for line in f:
        soup = BeautifulSoup(line, "html.parser")
        for word in soup.find_all('w'):
            if word['pos'] == "PM":
                train_sentence.append(word.getText() + "\t" + word['pos'])
            elif word['pos'] == "NN" or word['pos'] == "JJ":
                train_sentence.append(word.getText() + "\t" + word['pos'])
            else:
                train_sentence.append(word.getText() + "\t" + " 0 ")

        if "</sentence>" in line:
            doc.append("\n".join(train_sentence) + "\n")
            train_sentence = []

        if len(doc) == 500:
            f1.write("".join(doc))
            doc = []

f1.write("".join(doc))
f1.close()
