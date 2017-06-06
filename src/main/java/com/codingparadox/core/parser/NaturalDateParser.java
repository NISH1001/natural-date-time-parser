package com.codingparadox.core.parser;

import java.util.List;

import com.codingparadox.core.tokenizer.SentenceTokenizer;
import com.codingparadox.core.tokenizer.Tokenizer;
import com.codingparadox.core.tokenizer.WordTokenizer;

/**
 * It is used for parsing natural date
 *
 */
public class NaturalDateParser {
	private final Tokenizer wordTokenizer = new WordTokenizer();
	private final Tokenizer sentenceTokenizer = new SentenceTokenizer();

	/**
	 * Parse the given text
	 * 
	 * @param text
	 */
	public void parseDate(String text) {
		List<String> sentences = this.sentenceTokenizer.tokenize(text);
		for(String sentence : sentences) {
			List<String> words = this.wordTokenizer.tokenize(sentence);
			System.out.println("Sentence :: " + sentence);
			System.out.println("Event Type :: " + this.getEventType(words));
		}
	}

	/**
	 * Get the type of Event : PAST, FUTUTRE, PRESENT
	 * by analyzig the list of tokens.
	 * 
	 * The tokens are generated from a sentence.
	 * 
	 * @param tokens
	 * 		List of words
	 * @return
	 */
	public EventType getEventType(List<String> tokens ) {
		// get all past event's enum
		PastEvent[] pastEvents = PastEvent.values();
		// get all future event's eunum
		FutureEvent[] futureEvents = FutureEvent.values();

		PresentEvent[] presentEvents = PresentEvent.values();

		/**
		 * Use the tokens to predict the event type.
		 * 
		 * For now, simple comparison model is used
		 */
		boolean past = false;
		boolean present = false;
		boolean future = false;
		for(String token : tokens) {

			for(PastEvent pastEvent : pastEvents) {
				past = past || token.equalsIgnoreCase(pastEvent.getValue());
			}
			for(PresentEvent presentEvent : presentEvents) {
				present = present || token.equalsIgnoreCase(presentEvent.getValue());
			}
			for(FutureEvent futureEvent : futureEvents) {
				future = future || token.equalsIgnoreCase(futureEvent.getValue());
			}
		}
		if( (past && future) || (past && present) || (present && future) ) {
			return EventType.UNCERTAIN;
		}else if(past) {
			return EventType.PAST;
		} else if(present){
			return EventType.PRESENT;
		} else if(future) {
			return EventType.FUTURE;
		} else {
			return null;
		}
	}

	public void runTest() {
		String text = "2 weeks and 3 days after. I had a meeting yesterday. "
				+ "I have a meeting few days tomorrow yesterday. "
				+ "I will go today.";
		this.parseDate(text);
	}
}
