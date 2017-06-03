package com.codingparadox.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespaceProcessor;

public class WhitespaceProcessorTest {

	TextProcessor textProcessor = new WhitespaceProcessor();

	@Test
	public void processText() {
		String text = "Hello! I am    Paradox.  ";
		String expected = "Hello! I am Paradox.";
		
		String actual = this.textProcessor.processText(text);
		Assert.assertEquals(actual, expected);
	}
}
