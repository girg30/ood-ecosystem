package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.annvcit.util.Util;
import com.annvcit.util.Observable;
import com.annvcit.util.Observer;

import com.annvcit.model.Message;

/**
 * Lion (Sư tử) là một loài động vật ăn thịt ở Africa
 */
public class Lion extends ACarnivore implements Observable {

	private int count = 0;
	private int loops = 20;
	private int speed = 1;// very high
	private int heal = 1000000;
	
	private List<String> moves;

	public Lion() {}
	
	public Lion(int x, int y) {
		super(x, y);

		this.w = 16;
		this.h = 16;
		
		this.body = new Rectangle(x, y, w, h);
		this.moves = new ArrayList<String>();
		
		for (int i = 0; i < loops; i++)
			moves.add("up");
		for (int i = 0; i < loops; i++)
			moves.add("down");
		for (int i = 0; i < loops; i++)
			moves.add("left");
		for (int i = 0; i < loops; i++)
			moves.add("right");

		// it's radius
		int radiusX = body.x - (radius - body.width) / 2;
		int radiusY = body.y - (radius - body.height) / 2;
		radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
	}

	public void draw(Graphics g) {

		if (this.getCurrentState() instanceof ImplHungryState) {
			move();
		} else if (this.getCurrentState() instanceof ImplNormalState) {
			xd = 0; yd = 0;
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

	@Override
	public void move() {
		count++;
		if (count > moves.size() - 1) {
			Collections.shuffle(moves);
			count = 0;
			xd = 0;
			yd = 0;
		}

		switch (moves.get(count)) {
		case "up":
			moveUp();
			break;
		case "down":
			moveDown();
			break;
		case "left":
			moveLeft();
			break;
		case "right":
			moveRight();
			break;
		}

		setDelay(speed);
	}
	
	private void setDelay(int speed){
		try {
			Thread.sleep(speed);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void moveLeft() {
		body.x -= xd;
	}

	private void moveRight() {
		body.x += xd;
	}

	private void moveUp() {
		body.y -= yd;
	}

	private void moveDown() {
		body.y += yd;
	}

	private List<Antelope> findVictim(List<Antelope> antelopeList) {

		List<Antelope> victimList = new ArrayList<>();

		for (Antelope a : antelopeList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}

	private Antelope nearestVictim(List<Antelope> antelopeList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		Antelope antelope = null;
		for (int i = 0; i < antelopeList.size(); i++) {
			distance = Util.distance(this.body, antelopeList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				antelope = antelopeList.get(i);
			}
		}
		return antelope;
	}
	
	public void goHunt(List<Antelope> antelopeList) {
		move();
		int step = 2;
		List<Antelope> victimList = findVictim(antelopeList);
		Antelope victim = nearestVictim(victimList);
	
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
			System.out.println("victim null: " + victim == null);
			notifyObservers(messageHunt, this, victim);
			
		}
	
		setDelay(speed);
	}
	
	
	
	//***************************************************
	//				Observable						    *
	//***************************************************
	
	private Observer africa;
	private boolean isChanged = false;
	
	@Override
	public void setChanged() {
		isChanged = true;
	}
	
	@Override
	public void addObserver(Observer observer) {
		africa = observer;
	}
	
	@Override 
	public void removeObserver(Observer observer) {
		africa = null;
	}
	
	@Override
	public void notifyObservers(Object... objects) {
		if (isChanged) {
			africa.update(objects);
		}
	}
	
	
}
