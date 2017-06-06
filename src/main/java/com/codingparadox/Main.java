package com.codingparadox;

import java.util.List;

import org.joda.time.DateTime;

import com.codingparadox.core.parser.NaturalDateParser;
import com.codingparadox.core.tokenizer.SimpleDateTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

public class Main {
	public static void main(String[] args) {
/*		testTokenizer();
		testRegexTokezner();
		testDate();
*/		testNaturalDateParser();
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
		DateTime dt = new DateTime();
		System.out.println(dt.dayOfWeek().getAsText());
	}
	
	public static void testNaturalDateParser() {
		NaturalDateParser naturalDateParser = new NaturalDateParser();
		naturalDateParser.runTest();
	}
}
