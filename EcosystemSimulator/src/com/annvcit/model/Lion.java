package com.annvcit.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lion (Sư tử) là một loài động vật ăn thịt ở Africa
 */
public class Lion extends ACarnivore {

	private Rectangle body;
	private Rectangle radiusBound;

	private int enemyEat;
	private int count = 0;
	private int loops = 20;
	private int speed = 1;// very high
	
	private List<Antelope> antelopeList;
	private Antelope antelope;
	private List<String> moves;

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

		if (this.getCurrentState() instanceof ImplNormalState) {
			move();
		}

		// lion
		g.setColor(Color.ORANGE);
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
			distance = distance(this.body, antelopeList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				antelope = antelopeList.get(i);
			}
		}
		if (antelope != null) {
			this.antelope = antelope;
		}
		return antelope;
	}

	public void moveToVictim(List<Antelope> antelopeList) {
		int step = 2;
		this.antelopeList = antelopeList;
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
	
		/*
		 * Vòng for này tao viết bất hợp lí =]] if (victimX < body.x) { for
		 * (float i = 0; i < body.x - victimX; i++) { this.body.x -= i; }
		 * 
		 * }
		 * 
		 * else if (victimX > body.x) { for (float i = 0; i < victimX - body.x;
		 * i++) { this.body.x += i; } }
		 * 
		 * if (victimY < body.y) { for (float i = 0; i < body.y - victimY; i++)
		 * { this.body.y -= i; } }
		 * 
		 * else if (victimY > body.y) { for (float i = 0; i < victimY - body.y;
		 * i++) { this.body.y += i; } }
		 */
	
		if (body.intersects(victim.getBody())) {
			this.antelopeList.remove(antelope);
			if (enemyEat++ == 5) {
				setCurrentState(getNormalState());
			}
		}
	
		try {
			Thread.sleep(speed);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private double distance(Rectangle r1, Rectangle r2) {

		Point p1 = new Point(r1.x + r1.width / 2, r1.y + r1.height / 2);
		Point p2 = new Point(r2.x + r2.width / 2, r2.y + r2.height / 2);

		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)
				+ Math.pow(p2.getY() - p1.getY(), 2));
	}

}
