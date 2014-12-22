package model.plant;

import model.ICreature;
import model.Maps;
import model.MyPosition;

public class Grass implements ICreature {

	private static final long serialVersionUID = 0xA3L;
	private MyPosition position;

	public Grass(MyPosition position) {
		this.position = position;
	}

	public MyPosition getPosition() {
		return position;
	}

	public void setPosition(MyPosition position) {
		this.position = position;
	}

	@Override
	public void moveUp() {

	}

	@Override
	public void moveDown() {

	}

	@Override
	public void moveLeft() {

	}

	@Override
	public void moveRight() {

	}

	@Override
	public boolean attack(ICreature other) {
		return false;
	}

	@Override
	public boolean isReachable() {
		return true;
	}

	@Override
	public boolean isDead() {
		return false;
	}

	@Override
	public boolean isHungry() {
		return false;
	}

	@Override
	public boolean isDangerous() {
		return false;
	}

	@Override
	public boolean canMoveUp(Maps map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveDown(Maps map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveLeft(Maps map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveRight(Maps map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "GRASS";
	}

	@Override
	public void updatePosition(MyPosition newPosition) {
		this.position = newPosition;
	}

}
