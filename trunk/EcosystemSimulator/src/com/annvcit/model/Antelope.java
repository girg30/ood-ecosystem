package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Antelope (Linh Dương) là một loài động vật ăn cỏ ở Africa (Châu Phi)
 */
public class Antelope extends AHerbivore {
    
	public Antelope() {}
	
	public Antelope(int x, int y) {
		super(x, y);
		
		w = 16; h = 16;
		
		body = new Rectangle(x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(75, 139, 219));
		g.fillOval(body.x, body.y, body.width, body.height);
		move();
	}

}
