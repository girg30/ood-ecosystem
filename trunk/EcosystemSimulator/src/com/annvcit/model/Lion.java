package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Lion (Sư tử) là một loài động vật ăn thịt ở Africa
 */
public class Lion extends ACarnivore {

	public Lion() {}
	
	public Lion(int x, int y) {
		super(x, y);

	}

	public void draw(Graphics g) {
		power--;
		
		if (power == 900) this.setCurrentState(this.getHungryState()); 
		System.out.println(power);
		
		// lion
		if (sex == 'm') {
			color = Color.ORANGE;
			w = 20; h = 20;
		} else color = new Color(242, 207, 148);
		
		g.setColor(color);
		g.fillOval(body.x, body.y, body.width, body.height);
			
		if (this.getCurrentState() instanceof ImplHungryState) {
			// it's radius
			int radiusX = body.x - (radius - body.width) / 2;
			int radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);

			g.setColor(Color.WHITE);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);

		}

	}

}
