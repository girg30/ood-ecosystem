package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.annvcit.util.ImageResource;

/**
 * Antelope (Linh Dương) là một loài động vật ăn cỏ ở Africa (Châu Phi)
 */
public class Antelope extends AHerbivore {
    
	public Antelope() {}
	
	public Antelope(int x, int y) {
		super(x, y);
//		w = 16; h = 16;
		body = new Rectangle(x, y, w, h);
		
	}
	
	private void drawMySelf(Graphics g) {}
	
	private void drawHungryState(Graphics g) {
		if (this.getCurrentState() instanceof ImplHungryState) {
			// it's radius
			int radiusX = body.x - (radius - body.width) / 2;
			int radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);

			g.setColor(Color.PINK);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);

		}
	}
	
	private void drawStarvedState(Graphics g) {
		g.drawImage(avatar, body.x, body.y, body.width, body.height, null);
	}
	
	private void drawDeathState(Graphics g) {
		if (this.getCurrentState() instanceof ImplDeathState) {
			/*g.setColor(new Color(128, 4, 26));
			g.fillOval(body.x, body.y, body.width, body.height);*/
			if (power == DEAD_LINE*2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
		}
	}
	
	private void drawBreedState(Graphics g) {}

	@Override
	public void draw(Graphics g) {
		
		drawMySelf(g);
		drawHungryState(g);
		drawDeathState(g);
		drawStarvedState(g);
		
		power--;
		if (power == 500) this.setCurrentState(this.getHungryState());
		if (power < 0) this.setCurrentState(this.getDeathState());
		
		// lion
	/*	if (sex == 'm') {
			color = new Color(75, 139, 219);
			w = 20; h = 20;
		} else color = new Color(35, 129, 229);*/
		
//		g.setColor(color);
//		g.fillOval(body.x, body.y, body.width, body.height);
			
	

	}
	

}
