package com.codingparadox.core;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.tokenizer.SentenceTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;

public class SentenceTokenizerTest {
	private final Tokenizer tokenizer = new SentenceTokenizer();

	@Test
	public void tokenize() {
		List<String> actual = this.tokenizer.tokenize(TestValueStore.text);
		Assert.assertEquals(actual, TestValueStore.Expected.sentenceTokenizerTestTexts);
	}
}
