package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Lion (Sư tử) là một loài động vật ăn thịt ở Africa
 */
public class Lion extends ACarnivore {

	public Lion() {
	}

	public Lion(int x, int y) {
		super(x, y);

	}

	public void draw(Graphics g) {

		// lion
		if (isMale()) {
			color = Color.ORANGE;
			w = 20;
			h = 20;
		} else
			color = new Color(242, 207, 148);

		g.setColor(color);
		g.fillOval(body.x, body.y, body.width, body.height);

		// it's radius
		int radiusX = body.x - (radius - body.width) / 2;
		int radiusY = body.y - (radius - body.height) / 2;
		radiusBound = new Rectangle(radiusX, radiusY, radius, radius);

		power--;

		System.out.println(power);
		if (power == 700)
			this.setCurrentState(this.getHungryState());
		if (power == 0)
			this.setCurrentState(this.getStarvedState());
		if (power < DEAD_LINE * 2)
			this.setCurrentState(this.getDeathState());

		// *******************************************************//

		if (this.getCurrentState() instanceof ImplHungryState) {

			g.setColor(Color.WHITE);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);

		}

		if (this.getCurrentState() instanceof ImplDeathState) {
			System.out.println("Death");
			g.setColor(Color.RED);
			g.fillOval(body.x, body.y, body.width, body.height);

			if (power == DEAD_LINE * 2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
			// return;
		}

		if (this.getCurrentState() instanceof ImplStarvedState) {
			// TODO KHÔNG VÔ ĐÂY ĐƯỢC, GIỜ PHẢI LÀM SAO?????
			g.setColor(Color.RED);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);
			System.out.println("color red");

		}

	}

}
