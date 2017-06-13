package com.codingparadox;

import java.util.ArrayList;
import java.util.List;

import com.codingparadox.core.datetime.DateTimeEngine;
import com.codingparadox.core.languagemodel.LanguageModel;
import com.codingparadox.core.languagemodel.Ngram;
import com.codingparadox.core.languagemodel.NgramLanguageModel;
import com.codingparadox.core.languagemodel.NgramUtils;
import com.codingparadox.core.parser.NaturalDateParser;
import com.codingparadox.core.tokenizer.SentenceTokenizer;
import com.codingparadox.core.tokenizer.SimpleDateTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

public class Main {
	public static void main(String[] args) {
////		testTokenizer();
//		testRegexTokezner();
		testDate();
		testNaturalDateParser();
//		testNgram();
		testLanguageModel();
	}
	
	public static void testTokenizer() {
		String text = "Hello! I am Paradox. "
				+ "I am Gru. "
				+ "I speak in silence.";
		
		Tokenizer tokenizer = new WordTokenizer();
		List<String> tokens = tokenizer.tokenize(text);
		for(String token : tokens) {
			System.out.println(token);
		}
	}
	
	public static void testRegexTokezner() {
		String text = "My birthday is on 07/29/1994. In BS it will be 04-14-2051";
		Tokenizer simpleDateTokenizer = new SimpleDateTokenizer();
		List<String> dates = simpleDateTokenizer.tokenize(text);
		for(String date : dates) {
			System.out.println(date);
		}
	}
	
	public static void testDate() {
		DateTimeEngine dateTimeEngine = new DateTimeEngine();
		System.out.println(dateTimeEngine.getCurrentDateTime().year().get());
		System.out.println(dateTimeEngine.getDateTime(1994, 7, 29, 0, 0, 0).dayOfWeek().getAsText());
		System.out.println(dateTimeEngine.getYearsBefore(3));
	}
	
	public static void testNaturalDateParser() {
		NaturalDateParser naturalDateParser = new NaturalDateParser();
		naturalDateParser.runTest();
	}
	
	public static void testNgram() {
		String text = "Hello! I am Paradox. "
				+ "I am Gru. "
				+ "I speak in silence.";
		
		Tokenizer tokenizer = new WordTokenizer();
		List<String> tokens = tokenizer.tokenize(text.toLowerCase());
		Ngram ngram = new Ngram(2);
		ngram.updateNgram(tokens);
		System.out.println(ngram.getNgramCount("i", "am"));
		System.out.println(ngram.toString());
	}
	
	public static void testLanguageModel() {
		String text = "Hello! I am Paradox. "
				+ "I am Gru. "
				+ "I speak in silence.";
		
		Tokenizer sentenceTokenizer = new SentenceTokenizer();
		Tokenizer wordTokenizer = new WordTokenizer();
		List<String> sentences = sentenceTokenizer.tokenize(text.toLowerCase());

		List<List<String>> tokens = new ArrayList<List<String>>();
		for(String sentence : sentences) {
			tokens.add(wordTokenizer.tokenize(sentence));
		}

		LanguageModel languageModel = new NgramLanguageModel();
		languageModel.updateModel(tokens);
		
		System.out.println(languageModel.toString());
	}
}
