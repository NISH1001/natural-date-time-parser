package com.codingparadox.core.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This tokenizer splits/tokenizes a text 
 * into constituent sentences.
 * 
 * A list of sentence strings is returned.
 * 
 */
public class SentenceTokenizer implements Tokenizer {

    private final String sentenceTokenizerRegex = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)"
    		+ "[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

    private final Pattern re = Pattern.compile(this.sentenceTokenizerRegex, 
    		Pattern.MULTILINE | Pattern.COMMENTS);

	public List<String> tokenize(String text) {
		List<String> sentences = new ArrayList<String>();

		Matcher reMatcher = re.matcher(text);
		while (reMatcher.find()) {
			sentences.add(reMatcher.group());
		}
		return sentences;
	}

}
