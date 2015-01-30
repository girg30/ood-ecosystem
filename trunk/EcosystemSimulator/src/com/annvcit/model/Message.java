package com.annvcit.model;

public class Message {
	
	public static final String HUNT = "HUNT HERBIVORES...";
	public static final String EAT = "EAT PLANT...";
	public static final String REMOVE_ME = "REMOVE ME PLEASE, I'M ALREADY DEAD";
	public static final String FIGHT_ME = "FIGHTING...";
	public static final String MAKE_BABY = "COME HERE BABY.....";
	public static final String AFRICA_ENV ="CHANGE TO AFRICA";
	public static final String FINNISH_ENV = "CHANGE TO FINISH";
	
	private String content;
	
	public Message(String c) {
		this.content = c;
	}
	
	public String getContent() { return this.content; }
	public void setContent(String value) { this.content = value; }
}
