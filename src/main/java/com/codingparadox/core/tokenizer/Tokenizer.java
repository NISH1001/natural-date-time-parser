package com.codingparadox.core.tokenizer;

import java.util.List;

/**
 * A tokenizers actually splits the text into relevant tokens.
 * A list of tokens is generated which are used for further processes.
 *
 */
public interface Tokenizer {
	/**
	 * It tokenizes the given text/string to tokens.
	 * 
	 * @param text
	 * 		It is the text to be tokenized
	 * @return
	 * 		The list of tokens
	 */
	public List<String> tokenize(String text);
}
