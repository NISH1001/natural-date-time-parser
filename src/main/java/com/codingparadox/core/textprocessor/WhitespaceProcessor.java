package com.codingparadox.core.textprocessor;

/**
 * It is used to process the text based on whitespaces.
 * The final effect will be: 
 * 		trimming, reduction of multiple spaces, etc.
 *
 */
public class WhitespaceProcessor implements TextProcessor {

	public String processText(String text) {
		return text.trim().replaceAll("\\s+", " ");
	}
}
