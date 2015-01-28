package com.annvcit.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        
        this.moves = new ArrayList<String>();
		
		for (int i = 0; i < loops; i++)
			moves.add("up");
		for (int i = 0; i < loops; i++)
			moves.add("down");
		for (int i = 0; i < loops; i++)
			moves.add("left");
		for (int i = 0; i < loops; i++)
			moves.add("right");
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
    
	public void move() {
		count++;
		if (count > moves.size() - 1) {
			Collections.shuffle(moves);
			count = 0;
			/*xd = 0;
			yd = 0;*/
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
	
	protected void setDelay(int speed){
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
	
	public int getPower() { return this.power; }
    
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
    
    public void setSpeed(int value) { this.speed = value; }
    
    public void setXd(int value) { this.xd = value; }
    
    public void setYd(int value) { this.yd = value; }
    public void setPower(int value) { this.power = value; }
    
    //********************************
    //           ATTRIBUTES          *
    //********************************
    
    protected IAnimalState normalState;
    protected IAnimalState starvedState;
    protected IAnimalState hungryState;
    protected IAnimalState currentState;
    
    protected char sex; // m (male) and f (female)
    protected int power = 1000;
    
    /*position, width, height*/
    protected int x, y, w, h;
    protected int xd=2, yd=2; // x direction, y direction
    
    protected Rectangle body;
    protected Rectangle radiusBound;
    protected Color color;
    
    protected int count = 0;
	protected int loops = 2;
	protected int speed = 1;// very high
	protected List<String> moves;
}
