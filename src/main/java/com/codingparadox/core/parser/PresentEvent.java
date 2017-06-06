package com.codingparadox.core.parser;

public enum PresentEvent {
	TODAY("Today"),
	NOW("Now"),
	CURRENT("Current");
	
	private String value;

	PresentEvent(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
