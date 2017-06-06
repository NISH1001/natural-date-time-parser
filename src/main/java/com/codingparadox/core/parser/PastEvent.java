package com.codingparadox.core.parser;

public enum PastEvent {
	BEFORE("Before"),
	AGO("Ago"),
	BACK("Back"),
	YESTERDAY("Yesterday");
	
	private String value;
	
	PastEvent(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
