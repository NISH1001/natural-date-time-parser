package com.codingparadox.core.tokenizer;

/**
 * This will extract simple dates from the given text (sentence)
 * Eg:
 * 
 * Day, month, year => 29/07/1994
 * 
 * Month, Day, Year => 07/29/1994
 * 
 * Both DMY and MDY => 12/12/1978
 * 
 * Using whitespace as a delimiter => 29 07 1994
 * 
 * Using '- as a delimiter
 * 
 */
public class SimpleDateTokenizer extends RegexTokenizer {
	public static String regex = "(\\b(0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](\\d{4}|\\d{2})\\b)|(\\b(0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](\\d{4}|\\d{2})\\b)";
	
	public SimpleDateTokenizer(String regex) {
		super(regex);
	}
	
	public SimpleDateTokenizer() {
		this(SimpleDateTokenizer.regex);
	}
}
