package com.codingparadox;

import java.util.List;

import com.codingparadox.core.textprocessor.TextProcessor;
import com.codingparadox.core.textprocessor.WhitespaceProcessor;
import com.codingparadox.core.tokenizer.SentenceTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;

public class Main {
	public static void main(String[] args) {
		String text = "Hello! I am      paradox. I know nothing." 
				+ " People call me Gru. But, they also call me Er. Nishan";

		String text1 = "Hello! I am Paradox. "
				+ "I am Gru. "
				+ "I speak in silence.";
		
		TextProcessor whitespaceProcessor = new WhitespaceProcessor();

		Tokenizer sentenceTokenizer = new SentenceTokenizer();
		List<String> sentences = sentenceTokenizer.tokenize(whitespaceProcessor.processText(text1));
		for(String sentence : sentences) {
			System.out.println(sentence);
		}
	}
}
