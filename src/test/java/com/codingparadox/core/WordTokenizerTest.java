package com.codingparadox.core;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

public class WordTokenizerTest {
	private final Tokenizer tokenizer = new WordTokenizer();

	@Test( dependsOnGroups = { "WhitespacePunctuationProcessor"})
	public void tokenize() {
		List<String> actual = this.tokenizer.tokenize(TestValueStore.text);
		Assert.assertEquals(actual, TestValueStore.Expected.words);
	}
}
