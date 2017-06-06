package com.codingparadox;

import java.util.List;

import com.codingparadox.core.tokenizer.SimpleDateTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

public class Main {
	public static void main(String[] args) {
		String text = "Hello! I am Paradox. "
				+ "I am Gru. "
				+ "I speak in silence.";
		
		Tokenizer tokenizer = new WordTokenizer();
		List<String> tokens = tokenizer.tokenize(text);
		for(String token : tokens) {
			System.out.println(token);
		}
		testRegexTokezner();
	}
	
	public static void testRegexTokezner() {
		String text = "My birthday is on 07/29/1994. In BS it will be 04-14-2051";
		Tokenizer simpleDateTokenizer = new SimpleDateTokenizer();
		List<String> dates = simpleDateTokenizer.tokenize(text);
		for(String date : dates) {
			System.out.println(date);
		}
	}
}
