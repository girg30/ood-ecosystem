package com.annvcit.model;

import java.awt.Rectangle;

import java.util.List;

/**
 * lớp cha của các loài đv ăn thịt
 */
public abstract class ACarnivore extends AAnimal {
	
	protected int radius = 100; // bán kính tìm mồi
	
	protected Rectangle body;
	protected Rectangle radiusBound;
	
	public ACarnivore(int x, int y) { super(x, y); }
	
}
