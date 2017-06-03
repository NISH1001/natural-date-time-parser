package com.codingparadox.core.tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespaceProcessor;

/**
 * This tokenizer splits/tokenizes a text based on whitespaces.
 * 
 * Whitespaces are : spaces, tabs, newlines,
 * 
 * A list of words string is returned.
 *
 */
public class WhitespaceTokenizer implements Tokenizer {
	
	// Whitespace processor is used for preprocessing
	private final TextProcessor textProcessor = new WhitespaceProcessor();

	public List<String> tokenize(String text) {
		text = this.textProcessor.processText(text);
		return new ArrayList<String>(Arrays.asList(text.split(" ")));
	}
}
