package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.annvcit.util.Util;

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
		if (this.getCurrentState() instanceof ImplDeathState) {
			g.setColor(Color.RED);
			g.fillOval(body.x, body.y, body.width, body.height);
			if (power == DEAD_LINE*2) {
				setChanged();
				Message removeMeMessage = new Message(Message.REMOVE_ME);
				notifyObservers(removeMeMessage, this);
			}
			return;
		}
		
		if (power == 700) this.setCurrentState(this.getHungryState()); 
		if (power < 0) {
			this.setCurrentState(this.getDeathState());
			
		}

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
	
	public List<AHerbivore> findVictim(List<AHerbivore> antelopeList) {

		List<AHerbivore> victimList = new ArrayList<>();

		for (AHerbivore a : antelopeList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}

	public AHerbivore nearestVictim(List<AHerbivore> antelopeList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		AHerbivore antelope = null;
		for (int i = 0; i < antelopeList.size(); i++) {
			distance = Util.distance(this.body, antelopeList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				antelope = antelopeList.get(i);
			}
		}
		return antelope;
	}
	

	public void goHunt(List<AHerbivore> antelopeList) {
		int step = 2;
		List<AHerbivore> victimList = findVictim(antelopeList);
		AHerbivore victim = nearestVictim(victimList);
	
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
			Message messageHunt = new Message(Message.HUNT);
			setChanged();
			notifyObservers(messageHunt, this, victim);
			
		}
	
		setDelay(speed);
	}

}
