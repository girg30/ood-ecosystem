package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Lớp trừu tượng. Lớp cha của các loài động vật.
 * Ở đây định nghĩa các thuộc tính, hành vi chung của động vật.
 * */
public abstract class AAnimal {
    
	//********************************
    //           CONSTRUCTORS        *
    //********************************
	
    public AAnimal(int x, int y) {
        normalState = new ImplNormalState();
        starvedState = new ImplStarvedState();
        hungryState = new ImplHungryState();
        currentState =  normalState;
        
        this.x = x;
        this.y = y;
        
        // set default sex
        sex = 'f';
    }

    public AAnimal() {}
    
    //********************************
    //           METHODS             *
    //********************************
    
    /**
     * kiểm tra xem đv này có khác giới với động vật kia hay không
     * @param anotherAnimal đv khác
     * @return true nếu khác giới
     * */
    public boolean isOppositeSex(AAnimal anotherAnimal) {
        return this.sex != anotherAnimal.getSex();
    }
    
    public abstract void draw(Graphics g);
    protected abstract void move();
    
    //********************************
    //           GETTERS             *
    //********************************
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }

    public char getSex() { return sex; }
    
    public IAnimalState getNormalState() { return normalState; }
    public IAnimalState getStarvedState() { return starvedState; }
    public IAnimalState getHungryState() { return hungryState; }
    public IAnimalState getCurrentState() { return currentState; }
    
    //********************************
    //           SETTERS             *
    //********************************
    
    public void setNormalState(IAnimalState normalState) {
        this.normalState = normalState;
    }

    public void setStarvedState(IAnimalState starvedState) {
        this.starvedState = starvedState;
    }

    public void setHungryState(IAnimalState hungryState) {
        this.hungryState = hungryState;
    }

    public void setCurrentState(IAnimalState currentState) {
        this.currentState = currentState;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public void setXd(int value) { this.xd = value; }
    
    public void setYd(int value) { this.yd = value; }
    
    //********************************
    //           ATTRIBUTES          *
    //********************************
    
    protected IAnimalState normalState;
    protected IAnimalState starvedState;
    protected IAnimalState hungryState;
    protected IAnimalState currentState;
    
    protected char sex; // m (male) and f (female)
    
    /*position, width, height*/
    protected int x, y, w, h;
    protected int xd=2, yd=2; // x direction, y direction
    
    protected Rectangle body;
    protected Rectangle radiusBound;
    protected Color color;
}
