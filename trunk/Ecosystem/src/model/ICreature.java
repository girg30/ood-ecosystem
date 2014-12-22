package model;

import java.io.Serializable;

public interface ICreature extends Serializable{

	public MyPosition getPosition();

	public void updatePosition(MyPosition newPosition);

	public void moveUp();

	public void moveDown();

	public void moveLeft();

	public void moveRight();

	public boolean attack(ICreature other);

	public boolean isReachable();

	public boolean isDead();

	public boolean isHungry();

	public boolean isDangerous();

	public boolean canMoveUp(Maps map);

	public boolean canMoveDown(Maps map);

	public boolean canMoveLeft(Maps map);

	public boolean canMoveRight(Maps map);
	
	public String toString();
	
}
