package model.animal;

import model.ICreature;
import model.Maps;
import model.MyPosition;
import model.plant.Grass;
import model.plant.Plant;

public class Wolf implements ICreature {

	private static final long serialVersionUID = 0xA2L;
	private MyPosition position;
	private MyPosition previousPosition;
	private boolean _isDead;

	public Wolf(MyPosition position) {
		this.position = position;
		_isDead = false;
	}

	public MyPosition getPreviousPosition() {
		return previousPosition;
	}

	public void setIsDead(boolean isDead) {
		this._isDead = isDead;
	}

	@Override
	public MyPosition getPosition() {
		return this.position;
	}

	@Override
	public void updatePosition(MyPosition newPosition) {
		this.position = newPosition;
	}

	@Override
	public void moveUp() {
		previousPosition = position;
		updatePosition(new MyPosition(position.getX(), position.getY() - 1));
	}

	@Override
	public void moveDown() {
		previousPosition = position;
		updatePosition(new MyPosition(position.getX(), position.getY() + 1));
	}

	@Override
	public void moveLeft() {
		previousPosition = position;
		updatePosition(new MyPosition(position.getX() - 1, position.getY()));
	}

	@Override
	public void moveRight() {
		previousPosition = position;
		updatePosition(new MyPosition(position.getX() + 1, position.getY()));
	}

	@Override
	public boolean canMoveUp(Maps map) {
		try {
			int y = this.position.getY() - 1;
			if (y < 0)
				return false;

			MyPosition position = new MyPosition(this.position.getX(), y);
			ICreature creature = map.getCreatureAt(position);

			if (creature instanceof Lion) {
				return false;
			} else if (creature instanceof Wolf) {
				return false;
			} else if (creature instanceof Huou) {
				return true;
			} else if (creature instanceof Plant) {
				return false;
			} else if (creature instanceof Grass) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean canMoveDown(Maps map) {
		try {
			int y = this.position.getY() + 1;
			if (y > map.getMap().length - 1)
				return false;

			MyPosition position = new MyPosition(this.position.getX(), y);
			ICreature creature = map.getCreatureAt(position);

			if (creature instanceof Lion) {
				return false;
			} else if (creature instanceof Wolf) {
				return false;
			} else if (creature instanceof Huou) {
				return true;
			} else if (creature instanceof Plant) {
				return false;
			} else if (creature instanceof Grass) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean canMoveLeft(Maps map) {
		try {
			int x = this.position.getX() - 1;
			if (x < 0)
				return false;

			MyPosition position = new MyPosition(x, this.position.getY());
			ICreature creature = map.getCreatureAt(position);

			if (creature instanceof Lion) {
				return false;
			} else if (creature instanceof Wolf) {
				return false;
			} else if (creature instanceof Huou) {
				return true;
			} else if (creature instanceof Plant) {
				return false;
			} else if (creature instanceof Grass) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean canMoveRight(Maps map) {
		try {
			int x = this.position.getX() + 1;
			if (x > map.getMap()[0].length - 1)
				return false;

			MyPosition position = new MyPosition(x, this.position.getY());
			ICreature creature = map.getCreatureAt(position);

			if (creature instanceof Lion) {
				return false;
			} else if (creature instanceof Wolf) {
				return false;
			} else if (creature instanceof Huou) {
				return true;
			} else if (creature instanceof Plant) {
				return false;
			} else if (creature instanceof Grass) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean attack(ICreature other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReachable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return _isDead;
	}

	@Override
	public boolean isHungry() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDangerous() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "WOLF";
	}

}
