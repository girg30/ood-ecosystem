package actions;

import gui.EnvironmentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.MyPosition;
import model.animal.Huou;
import model.plant.Grass;

public class HuouAction implements ActionListener {

	private EnvironmentPanel environment;
	private Huou huou;
	private Random rd;

	public HuouAction(EnvironmentPanel environment, Huou huou) {
		this.environment = environment;
		this.huou = huou;
		rd = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int move = rd.nextInt(4);
		switch (move) {
		case 0:
			if (huou.canMoveUp(environment.getMaps())) {
				huou.moveUp();
				actionAfterMove();
			}
			break;
		case 1:
			if (huou.canMoveDown(environment.getMaps())) {
				huou.moveDown();
				actionAfterMove();
			}
			break;
		case 2:
			if (huou.canMoveLeft(environment.getMaps())) {
				huou.moveLeft();
				actionAfterMove();
			}
			break;
		case 3:
			if (huou.canMoveRight(environment.getMaps())) {
				huou.moveRight();
				actionAfterMove();
			}
			break;
		}
	}

	private void actionAfterMove() {
		MyPosition p1 = huou.getPosition();
		MyPosition p2 = huou.getPreviousPosition();
		environment.getMaps().getMap()[p1.getY()][p1.getX()] = huou;
		environment.getMaps().getMap()[p2.getY()][p2.getX()] = new Grass(p2);
		environment.updateText(p1, p2);
	}
}
