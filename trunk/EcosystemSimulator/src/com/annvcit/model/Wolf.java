package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.annvcit.util.ImageResource;

/**
 * Woft (Chó sói) là một động vật ăn thịt ở Finnish
 */
public class Wolf extends ACarnivore {

	public Wolf() {
	}

	public Wolf(int x, int y) {
		super(x, y);
	}

	private int timeout = 500;
	private int growUpTimeout = 200;

	private void drawMySelf(Graphics g) {
		radius = 200; // reset, để khi nó hết "chết đói" thì radius bình thường
		// lion
		// if (isMale()) { // lúc mới vô thì vẽ mấy cái hình này cho vui

		// color = Color.ORANGE;
		// w = 20;
		// h = 20;
		// } else{
		// color = new Color(242, 207, 148);
		// }

		// g.setColor(color);
		// g.fillOval(body.x, body.y, body.width, body.height);

		g.drawImage(avatar, body.x, body.y, body.width, body.height, null);

		// it's radius
		radiusX = body.x - (radius - body.width) / 2;
		radiusY = body.y - (radius - body.height) / 2;
		radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
	}

	private void conditionChangeState() {
		power--; // theo thời gian thì năng lượng của nó sẽ bị giảm (giảm theo hàm paint thôi :D)
		if (!isChild) {
			wantBreed--;
			timeout--;
		} else {
			growUpTimeout--;
			if (growUpTimeout < 0) {
				// body.width = 16;
				// body.height = 16;
				isChild = false;
				setAvartar(this.isMale() ? ImageResource.WOLF_MALE_NORMAL : ImageResource.WOLF_MALE_NORMAL);
				this.setCurrentState(this.getNormalState());
			}
		}

		if (timeout < 0) {
			wantBreed = 800;
			timeout = 500;
			this.setCurrentState(this.getStarvedState());
		}

		if (wantBreed <= 0 && wantBreed > -5) {
			wantBreed = wantBreed > -5 ? -10 : wantBreed;
			power = 701;
			this.setCurrentState(this.getBreedState());
		}

		if (power == 700)
			this.setCurrentState(this.getHungryState());
		else if (power == 0) {
			this.setCurrentState(this.getStarvedState());
			setAvartar(this.isMale() ? ImageResource.WOLF_MALE_NORMAL : ImageResource.WOLF_MALE_NORMAL);
		} else if (power <= DEAD_LINE) {
			// deadTimeout--;
			this.setCurrentState(this.getDeathState());
			setAvartar(this.isMale() ? ImageResource.WOLF_MALE_DEAD : ImageResource.WOLF_FEMALE_DEAD);
		}
	}

	private void drawHungryState(Graphics g) {
		if (this.getCurrentState() instanceof ImplHungryState) {
			// bật chế độ săn mồi
			g.setColor(Color.WHITE);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width, radiusBound.height);
		}

	}

	private void drawDeathState(Graphics g) {
		if (this.getCurrentState() instanceof ImplDeathState) {
			// request lên environment để được remove
			// g.setColor(Color.RED);
			// g.fillOval(body.x, body.y, body.width, body.height);
			if (power <= DEAD_LINE * 2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
		}
	}

	private void drawStarvedState(Graphics g) {
		if (this.getCurrentState() instanceof ImplStarvedState) {
			// đói quá => chết đói => mở rộng bán kính tìm thức ăn => ăn luôn đồng loại bất kể
			// đực, cái, già, trẻ, phụ ấu, gái mới lớn...
			radius = 500;
			radiusX = body.x - (radius - body.width) / 2;
			radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
			g.setColor(Color.RED);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width, radiusBound.height);
		}
	}

	private void drawBreedState(Graphics g) {
		if (this.getCurrentState() instanceof ImplBreedState) {
			radius = 900;
			radiusX = body.x - (radius - body.width) / 2;
			radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
			g.setColor(Color.GREEN);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width, radiusBound.height);
		}
	}

	public void draw(Graphics g) {

		drawMySelf(g);
		conditionChangeState();
		drawHungryState(g);
		drawStarvedState(g);
		drawDeathState(g);
		drawBreedState(g);

	}

}
