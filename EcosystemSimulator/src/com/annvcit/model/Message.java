package com.annvcit.model;

public class Message {
	
	public static final String HUNT = "HUNT HERBIVORES...";
	public static final String EAT = "EAT PLANT...";
	public static final String REMOVE_ME = "REMOVE ME PLEASE, I'M ALREADY DEAD";
	
	private String content;
	
	public Message(String c) {
		this.content = c;
	}
	
	public String getContent() { return this.content; }
	public void setContent(String value) { this.content = value; }
}
