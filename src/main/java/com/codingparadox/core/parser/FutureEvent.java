package com.codingparadox.core.parser;

public enum FutureEvent {
	
	AFTER("After"),
	NEXT("Next"),
	LATER("Later"),
	UPCOMING("Upcoming"),
	TOMORROW("Tomorrow");
	
	private String value;
	
	FutureEvent(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
