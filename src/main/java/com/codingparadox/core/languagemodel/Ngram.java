package com.codingparadox.core.languagemodel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

/**
 * Data structure to hold the ngram data
 *
 */
public class Ngram {
	private NgramType ngramType;

	private Map<List<String>, Double> data;
	
	private final Tokenizer wordTokenizer = new WordTokenizer();

	/**
	 * The constructor that accepts the ngram type
	 */
	public Ngram(NgramType ngramType){
		this.ngramType = ngramType;
		this.data = new HashMap<List<String>, Double>();
	}

	/**
	 * The constructor to accept the ngram's N value
	 * 
	 */
	public Ngram(int n){
		this(NgramType.fromInt(n));
	}

	/**
	 * Create ngram
	 * 
	 * @param tokens
	 * 		List of tokens. Tokens can be anything
	 */
	public void createNgram(List<String> tokens) {
		this.updateNgram(tokens);
	}

	/**
	 * Updates the ngram data from the list of token.
	 * 
	 * @param tokens
	 * 		The list of String/word/token used for updating the Ngram
	 */
	public void updateNgram(List<String> tokens) {
		int n = this.ngramType.getValue();
		int tokensLength = tokens.size();
		for(int i=0; i<tokensLength-n+1; ++i) {
			List<String> words = NgramUtils.generateNgramSequence(tokens, i, i+n);
			double ngramCount = 0;
			if(this.data.containsKey(words)) {
				ngramCount = this.data.get(words);
			} else {
				ngramCount = 0;
			}
			
			this.data.put(words, ++ngramCount);
		}
	}
	
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
	public double getNgramCount(List<String> ngramSequence) {
		if(this.data.containsKey(ngramSequence)) {
			return this.data.get(ngramSequence);
		}
		
		return 0.0;
	}
	
	/**
	 * Returns the count of given sequence of words/tokens/strings
	 * 
	 * @param strings
	 * 		Sequence of words/tokens/strings
	 * @return
	 * 		The ngram count of the sequence
	 */
	public double getNgramCount(String ... strings ) {
		List<String> ngramSequence = Arrays.asList(strings);
		return this.getNgramCount(ngramSequence);
	}

	
	/**
	 * Returns the total number of unique tokens (sequence of words) in the ngram model.
	 * 
	 * @param ngramType
	 * 		Ngram type
	 * @return
	 * 		size of the vocabulary
	 */
	public int getVocabularySize() {
		return this.data.size();
	}
	
	/**
	 * It returns the unique tokens in the ngram.
	 * That is, it returns all the ngram sequence in the given ngram model.
	 * 
	 * @param ngramType
	 * 		Ngram Type
	 * @return
	 * 		unique tokens
	 */
	public Set<List<String>> getUniqueTokens() {
		return this.data.keySet();
	}
	
	/**
	 * Returns the total number of ngram sequence in the ngram
	 * 
	 * @return
	 * 		
	 */
	public double getTotalNumberOfTokens() {
		double totalCount = 0;
		for(double count : this.data.values()) {
			totalCount += count;
		}
		return totalCount;
	}
	
	@Override
	public String toString() {
		String toReturn = this.ngramType.toString()
				+ "\nData :: " + this.data.toString()
				+ "\nVocabulary Size :: " + this.getVocabularySize()
				+ "\nUnique Tokens :: " + this.getUniqueTokens()
				+ "\nTotal Number of Tokens :: " + this.getTotalNumberOfTokens();
		return toReturn;
	}
}
