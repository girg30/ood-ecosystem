package com.annvcit.model;

import java.awt.Graphics;

import com.annvcit.util.ImageResource;

/**
 * Grass (bãi cỏ) là một loài thực vật ở Africa
 */
public class Grass extends APlant {
    
	public Grass() {}
	
	public Grass(int x, int y) {
		super(x, y);
		setAvatar(ImageResource.GRASS_TILE);
	}
	
	
	
	@Override
	public void draw(Graphics g) {
/*		g.setColor(new Color(4, 140, 16));
		g.fillRect(body.x, body.y, body.width, body.height);*/
		
		g.drawImage(avatar,body.x,body.y,body.width,body.height,null);
	}
}
