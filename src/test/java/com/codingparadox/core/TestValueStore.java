package com.codingparadox.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * It is the data store for dummy data
 * 
 */
public class TestValueStore {

	// expected
	public static class Expected {
		public static final String whitespaceProcessorTestText = "Hello! I am Paradox.";
		public static List<String> sentenceTokenizerTestTexts = 
				new ArrayList<String>(Arrays.asList("Hello!", "I am Paradox.", 
									"I am Gru.", 
									"I speak in silence."));
		
		public static List<String> words = 
				new ArrayList<String>(Arrays.asList("Hello!", "I", "am", "Paradox.",
						"I", "am", "Gru.",
						"I", "speak", "in", "silence."));
		
	}

	public static String whitespaceProcessorTestText = "Hello! I am    Paradox.  ";

	public static String text = "Hello! I am Paradox. " 
							+ "I am Gru. "
							+ "I speak in silence.";
}
