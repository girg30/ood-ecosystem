package com.annvcit.model;

public class Message {
	
	public static final String HUNT = "HUNT HERBIVORES...";
	
	private String content;
	
	public Message(String c) {
		this.content = c;
	}
	
	public String getContent() { return this.content; }
	public void setContent(String value) { this.content = value; }
}
