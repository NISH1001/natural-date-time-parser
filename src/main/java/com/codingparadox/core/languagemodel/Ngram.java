package com.codingparadox.core.languagemodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	}

	/**
	 * Updates the ngram data
	 * 
	 * @param tokens
	 */
	public void updateNgram(List<String> tokens) {
		int n = this.ngramType.getValue();
		int tokensLength = tokens.size();
		for(int i=0; i<tokensLength-n+1; ++i) {
//			String ngramString = concat(tokens, i, i+n);
//			List<String> words = this.wordTokenizer.tokenize(ngramString.toLowerCase());
			List<String> words = concatIntoList(tokens, i, i+n);
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
	 * It concatenates the list of string into ngram
	 * 
	 * @param words
	 * 		List of words
	 * @param start
	 * 		Start index for first word in the ngram
	 * @param end
	 * 		End index for end word in the ngram
	 * @return
	 * 		Ngram words concatenated into String
	 */
	public static String concat(List<String> tokens, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + tokens.get(i));
		return sb.toString();
	}
	
	/**
	 * Create list of constituent words for the single ngram
	 * Eg:
	 *  	["I", "am", "fine"]
	 * 
	 * @param tokens
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> concatIntoList(List<String> tokens, int start, int end) {
		List<String> ngram = new ArrayList<String>();
		for(int i = start; i < end; ++i) {
			ngram.add(tokens.get(i));
		}
		return ngram;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
}
