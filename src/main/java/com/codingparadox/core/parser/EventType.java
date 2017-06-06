package com.codingparadox.core.parser;

public enum EventType {
	PAST("Past"),
	FUTURE("Future"),
	PRESENT("Today"),
	UNCERTAIN("Uncertain");
	
	private String value;
	
	EventType(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
