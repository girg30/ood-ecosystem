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
			if (power <= DEAD_LINE*2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
		}
	}
	
	private void drawBreedState(Graphics g) {
		if(this.getCurrentState() instanceof ImplBreedState){
			radius = 500;
			radiusX = body.x - (radius - body.width) / 2;
			radiusY = body.y - (radius - body.height) / 2;
			radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
			g.setColor(Color.GREEN);
			g.drawOval(radiusBound.x, radiusBound.y, radiusBound.width,
					radiusBound.height);
		}
	}

	@Override
	public void draw(Graphics g) {
		
		drawMySelf(g);
		conditionChangeState();
		drawHungryState(g);
		drawStarvedState(g);
		drawDeathState(g);
		drawBreedState(g);
		
		// lion
	/*	if (sex == 'm') {
			color = new Color(75, 139, 219);
			w = 20; h = 20;
		} else color = new Color(35, 129, 229);*/
		
//		g.setColor(color);
//		g.fillOval(body.x, body.y, body.width, body.height);
			
	

	}
	
	private int timeout = 500;
	private int growUpTimeout = 200;
	
	private void conditionChangeState() {
		power--; // theo thời gian thì năng lượng của nó sẽ bị giảm (giảm theo hàm paint thôi :D)
		if (!isChild) {
			wantBreed--;
			timeout--;
		} else {
			growUpTimeout--;
			if (growUpTimeout < 0) {
//				body.width = 16;
//				body.height = 16;
				isChild = false;
				setAvartar(this.isMale() ? ImageResource.ANTELOPE_MALE_NORMAL : ImageResource.ANTELOPE_FEMALE_NORMAL);
				this.setCurrentState(this.getNormalState());
			}
		}

		if (timeout < 0) {
			wantBreed = 800;
			timeout = 500;
			this.setCurrentState(this.getStarvedState());
		}
		
		if (wantBreed <= 0 && wantBreed > -5) {
			wantBreed = wantBreed >-5 ? -10: wantBreed;
			power = 701;
			this.setCurrentState(this.getBreedState());
		}
		
		if (power == 700)
			this.setCurrentState(this.getHungryState());
		else if (power == 0){
			this.setCurrentState(this.getStarvedState());
			setAvartar(this.isMale() ? ImageResource.ANTELOPE_MALE_NORMAL : ImageResource.ANTELOPE_FEMALE_NORMAL);
		}else if (power <= DEAD_LINE ){
			this.setCurrentState(this.getDeathState());
			setAvartar(this.isMale() ? ImageResource.ANTELOPE_MALE_DEAD : ImageResource.ANTELOPE_FEMALE_DEAD);
		}
	}

}
