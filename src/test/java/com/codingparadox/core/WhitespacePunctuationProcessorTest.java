package com.codingparadox.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespacePunctuationProcessor;

public class WhitespacePunctuationProcessorTest {
	private final TextProcessor textProcessor = new WhitespacePunctuationProcessor();

	@Test( groups = "WhitespacePunctuationProcessor")
	public void processText() {
		String actual = this.textProcessor.processText(TestValueStore.text);
		Assert.assertEquals(actual, TestValueStore.Expected.whitespacePunctuationProcessorTestText);
	}
}
