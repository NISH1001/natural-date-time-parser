package com.codingparadox.core;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WhitespaceTokenizer;

public class WhitespaceTokenizerTest {
	
	private final Tokenizer whitespaceTokenizer = new WhitespaceTokenizer();

	@Test( dependsOnGroups = { "WhitespaceProcessor"})
	public void tokenize() {
		List<String> actual = this.whitespaceTokenizer.tokenize(TestValueStore.text);
		Assert.assertEquals(actual, TestValueStore.Expected.words);
	}
}
