package com.annvcit.model;

import java.awt.Rectangle;

/**
 * lớp cha của các loài đv ăn thịt
 */
public abstract class ACarnivore extends AAnimal {
	
	protected int radius = 500; // bán kính tìm mồi
	
	protected Rectangle body;
	protected Rectangle radiusBound;
	
	public ACarnivore(int x, int y) { super(x, y); }
	
}
