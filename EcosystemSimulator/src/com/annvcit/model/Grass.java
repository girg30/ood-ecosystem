package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Grass (bãi cỏ) là một loài thực vật ở Africa
 */
public class Grass extends APlant {
    
	public Grass() {}
	
	public Grass(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(4, 140, 16));
		g.fillRect(body.x, body.y, body.width, body.height);
	}
}
