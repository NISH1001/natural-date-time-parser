package com.codingparadox.core.textprocessor;

/**
 * It reduces multiple spaces along with punctuations to single space.
 * Eg:
 * 		"Hello!  I am Paradox."
 * is reduced to
 * 		"Hello I am Paradox."
 * 
 * NOTE:
 * 		The punctuation at the end of the text is not processed.
 * 
 */
public class WhitespacePunctuationProcessor implements TextProcessor {

	public String processText(String text) {
		return text.trim().replaceAll("(\\s+)|([,!.]\\s+)", " ");
	}
}
