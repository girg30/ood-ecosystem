package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.annvcit.util.Util;

/**
 * Antelope (Linh Dương) là một loài động vật ăn cỏ ở Africa (Châu Phi)
 */
public class Antelope extends AHerbivore {
    
	public Antelope() {}
	
	public Antelope(int x, int y) {
		super(x, y);
//		w = 16; h = 16;
		body = new Rectangle(x, y, w, h);
		
//		setAvartar(this.isMale() ? ImageResource.LION_MALE_NORMAL : ImageResource.LION_FEMALE_NORMAL);
	}
	
	

	@Override
	public void draw(Graphics g) {
		power--;
		if (this.getCurrentState() instanceof ImplDeathState) {
			g.setColor(new Color(128, 4, 26));
			g.fillOval(body.x, body.y, body.width, body.height);
			if (power == DEAD_LINE*2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
			return;
		}
		
		if (power == 500) this.setCurrentState(this.getHungryState());
		if (power < 0) {
			this.setCurrentState(this.getDeathState());
		}
		
		// lion
		if (sex == 'm') {
			color = new Color(75, 139, 219);
			w = 20; h = 20;
		} else color = new Color(35, 129, 229);
		
		g.setColor(color);
		g.fillOval(body.x, body.y, body.width, body.height);
			
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

	@Override
	public void goEat(List<APlant> plantList) {
		int step = 2;
		List<APlant> victimList = findPlant(plantList);
		APlant victim = nearestPlant(victimList);
	
		if (victim == null)
			return;
	
		int victimX = victim.getBody().x;
		int victimY = victim.getBody().y;
	
		if (victimX < body.x) {
			this.body.x -= step;
		}else if (victimX > body.x) {
			this.body.x += step;
		}
	
		if (victimY < body.y) {
			this.body.y -= step;
		}else if (victimY > body.y) {
			this.body.y += step;
		}
	
		if (body.intersects(victim.getBody())) {
			Message messageEat = new Message(Message.EAT);
			setChanged();
			notifyObservers(messageEat, this, victim);
			
		}
	
		Util.setDelay(speed);
		
	}

	@Override
	public List<APlant> findPlant(List<APlant> plantList) {
		List<APlant> victimList = new ArrayList<>();

		for (APlant a : plantList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}

	@Override
	public APlant nearestPlant(List<APlant> plantList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		APlant plant = null;
		for (int i = 0; i < plantList.size(); i++) {
			distance = Util.distance(this.body, plantList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				plant = plantList.get(i);
			}
		}
		return plant;
	}
	
	

}
