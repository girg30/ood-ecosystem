package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

import java.util.List;
import java.util.ArrayList;

/**
 * Lion (Sư tử) là một loài động vật ăn thịt ở Africa
 */
public class Lion extends ACarnivore {
    
	private Rectangle body;
	private Rectangle radiusBound;

	public Lion(int x, int y) { 
    	super(x, y);
    	
    	this.w = 16; 
    	this.h = 16;
    	this.body = new Rectangle(x, y, w, h);
    	radiusBound = body;
    }
    
    public void draw(Graphics g) {
    	move();
    	
    	// lion
    	g.setColor(Color.ORANGE);
    	g.fillOval(body.x, body.y, body.width, body.height);
    	
    	if (this.getCurrentState() instanceof ImplHungryState) {
	    	// it's radius
    		int radiusX = body.x - (radius - body.width) / 2;
    		int radiusY = body.y - (radius - body.height) / 2;
    		radiusBound = new Rectangle(radiusX, radiusY, radius, radius);
    		g.setColor(Color.YELLOW);
    		g.fillRect(radiusBound.x, radiusBound.y, radiusBound.width, radiusBound.height);
	    	g.setColor(Color.WHITE);
	    	g.fillOval(radiusBound.x, radiusBound.y, radiusBound.width, radiusBound.height);
	    	
    	}
    	// lion
    	g.setColor(Color.ORANGE);
    	g.fillOval(body.x, body.y, body.width, body.height);
    	
    }

    @Override
    public void move() {
    	body.x += xd;
    	body.y += yd;
    }
    
    public List<Antelope> findVictim(List<Antelope> antelopes) {
    	List<Antelope> victimList = new ArrayList<>();
    	
    	for (Antelope a : antelopes) {
    		if (this.radiusBound.intersects(a.getBody())) {
    			victimList.add(a);
    		}
    	}
    	System.out.println("victims: " + victimList.size());
    	return victimList;
    }

}
