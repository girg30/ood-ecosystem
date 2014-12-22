package actions;

import gui.EnvironmentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.MyPosition;
import model.animal.Wolf;
import model.plant.Grass;

public class WolfAction implements ActionListener {

	private EnvironmentPanel environment;
	private Random rd;
	private Wolf wolf;

	public WolfAction(EnvironmentPanel environment, Wolf wolf) {
		this.environment = environment;
		this.wolf = wolf;
		rd = new Random();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int move = rd.nextInt(4);
		switch (move) {
		case 0:
			if (wolf.canMoveUp(environment.getMaps())) {
				wolf.moveUp();
				actionAfterMove();
			}
			break;
		case 1:
			if (wolf.canMoveDown(environment.getMaps())) {
				wolf.moveDown();
				actionAfterMove();
			}
			break;
		case 2:
			if (wolf.canMoveLeft(environment.getMaps())) {
				wolf.moveLeft();
				actionAfterMove();
			}
			break;
		case 3:
			if (wolf.canMoveRight(environment.getMaps())) {
				wolf.moveRight();
				actionAfterMove();
			}
			break;
		}
	}

	private void actionAfterMove() {
		MyPosition p1 = wolf.getPosition();
		MyPosition p2 = wolf.getPreviousPosition();
		// if(environment.getMaps().getCreatureAt(p1) instanceof Huou){
		// environment.getMaps().getMap()[p2.getY()][p2.getX()]
		// }
		environment.getMaps().getMap()[p1.getY()][p1.getX()] = wolf;
		environment.getMaps().getMap()[p2.getY()][p2.getX()] = new Grass(p2);
		environment.updateText(p1, p2);
	}

}
