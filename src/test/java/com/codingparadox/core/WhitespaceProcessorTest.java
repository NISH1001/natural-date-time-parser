package com.codingparadox.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespaceProcessor;

public class WhitespaceProcessorTest {

	TextProcessor textProcessor = new WhitespaceProcessor();

	@Test( groups = "WhitespaceProcessor")
	public void processText() {
		String actual = this.textProcessor.processText(TestValueStore.text);
		Assert.assertEquals(actual, TestValueStore.Expected.whitespaceProcessorTestText);
	}
}
