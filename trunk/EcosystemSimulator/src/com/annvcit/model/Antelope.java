package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Antelope (Linh Dương) là một loài động vật ăn cỏ ở Africa (Châu Phi)
 */
public class Antelope extends AHerbivore {
    
	private Rectangle body;
	
	public Antelope(int x, int y) {
		super(x, y);
		
		w = 30; h = 30;
		
		body = new Rectangle(x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(75, 139, 219));
		g.fillOval(body.x, body.y, body.width, body.height);
		
		g.setColor(Color.RED);
		g.fillRect(body.x, body.y, body.width, body.height);
	}
	
	@Override
	public void move() {
		body.x += xd;
		body.y += yd;
	}
	
	public Rectangle getBody() { return this.body; }

}
