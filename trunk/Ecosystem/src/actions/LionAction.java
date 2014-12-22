package actions;

import gui.EnvironmentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.MyPosition;
import model.animal.Lion;
import model.plant.Grass;

public class LionAction implements ActionListener{
	private EnvironmentPanel environment;
	private Random rd;
	private Lion lion;
	
	public LionAction(EnvironmentPanel environment, Lion lion) {
		this.environment = environment;
		this.lion = lion;
		rd = new Random();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int move = rd.nextInt(4);
		switch (move) {
		case 0:
			if (lion.canMoveUp(environment.getMaps())) {
				lion.moveUp();
				actionAfterMove();
			}
			break;
		case 1:
			if (lion.canMoveDown(environment.getMaps())) {
				lion.moveDown();
				actionAfterMove();
			}
			break;
		case 2:
			if (lion.canMoveLeft(environment.getMaps())) {
				lion.moveLeft();
				actionAfterMove();
			}
			break;
		case 3:
			if (lion.canMoveRight(environment.getMaps())) {
				lion.moveRight();
				actionAfterMove();
			}
			break;
		}
	}

	private void actionAfterMove() {
		MyPosition p1 = lion.getPosition();
		MyPosition p2 = lion.getPreviousPosition();
		environment.getMaps().getMap()[p1.getY()][p1.getX()] = lion;
		environment.getMaps().getMap()[p2.getY()][p2.getX()] = new Grass(p2);
		environment.updateText(p1, p2);
	}
}
