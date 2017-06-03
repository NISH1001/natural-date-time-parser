package com.codingparadox.core;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.tokenizer.SentenceTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;

public class SentenceTokenizerTest {
	private String text = "Hello! I am Paradox. "
			+ "I am Gru. "
			+ "I speak in silence.";
	
	private final Tokenizer tokenizer = new SentenceTokenizer();

	@Test
	public void tokenize() {
		List<String> expected = new ArrayList<String>();
		expected.add("Hello!");
		expected.add("I am Paradox.");
		expected.add("I am Gru.");
		expected.add("I speak in silence.");
		
		List<String> actual = this.tokenizer.tokenize(text);
		
		Assert.assertEquals(actual, expected);
	}
}
