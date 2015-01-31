package com.annvcit.model;

import java.awt.Graphics;

import com.annvcit.util.ImageResource;

/**
 * Willow (cây Liễu) là một loài thực vật ở Finnish
 */
public class Willow extends APlant {
	public Willow() {
		System.out.println("Crate new Willow");
	}
	
	public Willow(int x, int y){
		super(x,y);
		setAvatar(ImageResource.GRASS_TILE);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(avatar,body.x,body.y,body.width,body.height,null);
	}

}
