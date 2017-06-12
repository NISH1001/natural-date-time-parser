package com.codingparadox.core.languagemodel;

/**
 * 
 * It is the enum for Ngram type
 *
 */
public enum NgramType {
	UNIGRAM(1),
	BIGRAM(2),
	TRIGRAM(3);
	
	private int value;
	
	private NgramType(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Get NgramType enum for the n value of the ngram
	 * 
	 * @param n
	 * 		N value of the ngram
	 * @return
	 * 		NgramType enum
	 */
	public static NgramType fromInt(int n) {
		for (NgramType ngramType : NgramType.values()) {
			if (ngramType.getValue() == n) {
				return ngramType;
			}
		}
		return null;
	}
}
