package model;

import java.io.Serializable;

public class Maps implements Serializable {
	private static final long serialVersionUID = 0xA2BL;

	private ICreature[][] map;

	public Maps(ICreature[][] map) {
		this.map = map;
	}

	public Maps() {

	}

	public ICreature getCreatureAt(MyPosition position) {
		return map[position.getY()][position.getX()];
	}

	public void setMap(ICreature[][] map) {
		this.map = map;
	}

	public ICreature[][] getMap() {
		return map;
	}

}
