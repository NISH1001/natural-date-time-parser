package com.codingparadox.core.languagemodel;

import java.util.List;
import java.util.Set;

public interface LanguageModel {
	/**
	 * It is used to update the language model based on list of sentence/text.
	 * Each text is a list of tokens.
	 * 
	 * @param tokens
	 * 		It is the list of sentence
	 */
	public void updateModel(List<List<String>> tokens);
	
	/**
	 * Returns the ngram count for the particular sequence of token(string)
	 * 
	 * @param ngram
	 * 		List of string/word/token whose count is to be returned
	 * @param ngramType
	 * 		Ngram type
	 * @return
	 * 		Count of the ngram
	 */
	public double getNgramCount(List<String> ngram, NgramType ngramType);
	
	/**
	 * Returns the total number of unique tokens (sequence of words) in the ngram model.
	 * 
	 * @param ngramType
	 * 		Ngram type
	 * @return
	 * 		size of the vocabulary
	 */
	public int getVocabularySize(NgramType ngramType);
	
	/**
	 * It returns the unique tokens in the model.
	 * That is, it returns all the ngram sequence in the given ngram model.
	 * 
	 * @param ngramType
	 * 		Ngram Type
	 * @return
	 * 		unique tokens
	 */
	public Set<List<String>> getUniqueTokens(NgramType ngramType);
	
	/**
	 * Returns the total number of tokens in the model
	 * 
	 * @param ngramType
	 * 		Ngram type
	 * @return
	 * 		Total number of tokens in the ngram
	 */
	public double getTotalNumberofTokens(NgramType ngramType);
}

