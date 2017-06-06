package com.codingparadox.core.tokenizer;

import java.util.ArrayList;
import java.util.List;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespacePunctuationProcessor;

/**
 * It splits the given text into words.
 * The tokenization happens by whitespaces or punctuations.
 * 
 */
public class WordTokenizer implements Tokenizer {
	
	/**
	 * It is used for preprocessing the text just in case 
	 * input is very raw
	 */
	private final TextProcessor textProcessor = new WhitespacePunctuationProcessor();

	public List<String> tokenize(String text) {
		List<String> tokens = new ArrayList<String>();
		text = this.textProcessor.processText(text);
		String[] words = text.split(" ");
		for(String word : words) {
			if(word.endsWith(".") || word.endsWith("!")) {
				word = word.substring(0, word.length()-1);
			}
			tokens.add(word);
		}
		return tokens;
	}
}
