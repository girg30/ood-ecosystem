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
	
	private int timeout = 500;

	public void draw(Graphics g) {
		radius = 200; // reset, để khi nó hết "chết đói" thì radius bình thường
		// lion
		if (isMale()) { // lúc mới vô thì vẽ mấy cái hình này cho vui
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

		power--; // theo thời gian thì năng lượng của nó sẽ bị giảm (giảm theo hàm paint thôi :D)
		if (!isChild) {
			wantBreed--;
			timeout--;
		}

		if (timeout < 0) {
			wantBreed = 800;
			this.setCurrentState(this.getStarvedState());
		}
		
		if (wantBreed <= 0 && wantBreed > -5) {
			wantBreed = -1;
			power = 701;
			this.setCurrentState(this.getBreedState());
		}
		if (power == 700)
			this.setCurrentState(this.getHungryState());
		if (power == 0)
			this.setCurrentState(this.getStarvedState());
		if (power < DEAD_LINE )
			this.setCurrentState(this.getDeathState());

		// *******************************************************//

		if (this.getCurrentState() instanceof ImplHungryState) {
			// bật chế độ săn mồi
			g.setColor(Color.WHITE);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);

		}

		if (this.getCurrentState() instanceof ImplDeathState) {
			// request lên environment để được remove
			g.setColor(Color.RED);
			g.fillOval(body.x, body.y, body.width, body.height);

			if (power == DEAD_LINE * 2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
		}

		if (this.getCurrentState() instanceof ImplStarvedState) {
			// đói quá => chết đói => mở rộng bán kính tìm thức ăn => ăn luôn đồng loại bất kể
			// đực, cái, già, trẻ, phụ ấu, gái mới lớn...
			radius = 500;
			radiusX = body.x - (radius - body.width) / 2;
			radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);

			g.setColor(Color.RED);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);
		}
		
		if(this.getCurrentState() instanceof ImplBreedState){
			radius = 900;
			radiusX = body.x - (radius - body.width) / 2;
			radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
			g.setColor(Color.GREEN);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);
		}

	}

}
