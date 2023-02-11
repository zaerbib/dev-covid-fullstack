package com.covid.dev.util.event;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class AfterReadyEvent extends ApplicationEvent{
	private String message;

	public AfterReadyEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
