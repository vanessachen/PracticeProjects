'''
import nltk

nltk.download()
'''

import nltk.classify.util
from nltk.classify import NaiveBayesClassifier
from nltk.corpus import movie_reviews
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.corpus import wordnet

#extract all words from this sentence, but doesn't extract punctuation marks & will not handle every type of sentence
'''
sentence = "The Quick brown fox, Jumps over the lazy little dog. Hello World."
sentence.split(" ")
['The',
 'Quick',
 'brown',
 'fox,',
 'Jumps',
 'over',
 'the',
 'lazy',
 'little',
 'dog.',
 'Hello',
 'World.']
 '''

 #use word_tokenize() from nltk library, captures all punctuation
'''
word_tokenize(sentence)

['The',
 'Quick',
 'brown',
 'fox',
 ',',
 'Jumps',
 'over',
 'the',
 'lazy',
 'little',
 'dog',
 '.',
 'Hello',
 'World',
 '.']
'''

#can also tag the ype of all_en1_words
'''
nltk.pos_tag(w)

[('The', 'DT'),
 ('Quick', 'NNP'),
 ('brown', 'NN'),
 ('fox', 'NN'),
 (',', ','),
 ('Jumps', 'NNP'),
 ('over', 'IN'),
 ('the', 'DT'),
 ('lazy', 'JJ'),
 ('little', 'JJ'),
 ('dog', 'NN'),
 ('.', '.'),
 ('Hello', 'NNP'),
 ('World', 'NNP'),
 ('.', '.')]
'''

#print definition of any words
syn = wordnet.synsets("speak")
print("word(s): {}".format(syn))

num_defs = len(syn)
#print (hyp.hypernyms())

for i in range (num_defs):

    converted_name = syn[i].name()[:-5]
    print("name of definition {}: {}".format((i+1),converted_name))
    print("                                                                  ")
    print("definition {}: {}".format((i+1),syn[i].definition()))
    print("                                                                  ")
    print("example(s) of word in use: {}".format(syn[i].examples()))
    print("                                                                  ")

print_hypernym = input("Print the word's hypernym? Enter yes or no: ")
print_hyponym = input("Print the word's hypornym? Enter yes or no: ")
hyp = wordnet.synsets("speak")[0]

if print_hypernym == 'yes':
    converted_hypernym = hyp[i].hypernyms()
    print("word {} hypernym: {}".format((i+1), converted_hypernym))
if print_hypernym == 'yes':
    converted_hyponym = hyp[i].hyponyms()
    print("word {} hypernym: {}".format((i+1), converted_hyponym))
