package com.codingparadox.core.tokenizer;

/**
 * This tokenizer splits/tokenizes a text 
 * into constituent sentences.
 * 
 * A list of sentence strings is returned.
 * 
 */
public class SentenceTokenizer extends RegexTokenizer {
	
	public static String regex = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)"
				+ "[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

	public SentenceTokenizer(String regex) {
		super(regex);
	}

	public SentenceTokenizer() {
		this(SentenceTokenizer.regex);
	}
}
