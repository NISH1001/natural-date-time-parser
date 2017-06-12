package com.codingparadox.core.languagemodel;

import java.util.ArrayList;
import java.util.List;

public class NgramUtils {
	
	/**
	 * Prevent the intantiation
	 */
	private NgramUtils(){}

	/**
	 * Creates list of constituent words for a single ngram.
	 * That is: generates a single ngram
	 * 
	 * Eg:
	 *  	["I", "am", "fine"]
	 * 
	 * @param tokens
	 * 		It is the text that has been tokenized to words
	 * @param start
	 * 		From where the ngram sequence is to be generated from the tokens
	 * @param end
	 * 		Upto where the ngram sequence is to be generated from the tokens
	 * @return
	 * 		The sequence of String/word (single ngram sequence)
	 */
	public static List<String> generateNgramSequence(List<String> tokens, int start, int end) {
		List<String> ngram = new ArrayList<String>();
		for(int i = start; i < end; ++i) {
			ngram.add(tokens.get(i));
		}
		return ngram;
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
	 * 
	 * @param tokens
	 * @param n
	 * @return
	 */
	public static List<List<String>> generateNgrams(List<String> tokens, int n) {
		List<List<String>> ngrams = new ArrayList<List<String>>();
		for(int i=0; i<tokens.size() - n + 1; ++i) {
			ngrams.add(generateNgramSequence(tokens, i, i + n -1));
		}
		return ngrams;
	}

}
