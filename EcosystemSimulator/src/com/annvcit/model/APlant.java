package com.annvcit.model;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;

import java.net.URL;

import javax.swing.ImageIcon;

import com.annvcit.util.Observable;
import com.annvcit.util.Observer;


/**
 * lớp cha của các lòa thực vật
 */
public abstract class APlant implements Observable {
	protected int x, y, w, h;
	protected int power = 1000;
	protected Rectangle body;
    protected Color color;
    
    protected Image avatar;
    
    private Observer environment;
	private boolean isChanged = false;
	
	public void setAvatar(URL avatarURL) {
		ImageIcon icon = new ImageIcon(avatarURL);
		avatar = icon.getImage();
		
		w = icon.getIconWidth();
		h = icon.getIconHeight();
		
		body.width = w;
		body.height = h;
	}
	
	@Override
	public void setChanged() {
		isChanged = true;
	}
	
	@Override
	public void addObserver(Observer observer) {
		environment = observer;
	}
	
	@Override 
	public void removeObserver(Observer observer) {
		environment = null;
	}
	
	@Override
	public void notifyObservers(Object... objects) {
		if (isChanged) {
			environment.update(objects);
		}
	}
	

    //********************************
    //           METHODS        	 *
    //********************************
    
    public abstract void draw(Graphics g);
    
    
    
  //********************************
  //           CONSTRUCTORS        *
  //********************************
	
    public APlant(int x, int y) {
        this.x = x;
        this.y = y;

		this.w = 23;
		this.h = 23;
		
		this.body = new Rectangle(x, y, w, h);
        
    }

    public APlant() {}
    
    
    
    //********************************
    //           GETTERS             *
    //********************************
    
    public int getPower() { return this.power; }
    public Rectangle getBody() { return this.body; }
    
    
    //********************************
    //           SETTERS             *
    //********************************
    
    public void setColor(Color value) {
    	this.color = value;
    }
}
