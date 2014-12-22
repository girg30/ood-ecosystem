package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.IColor;
import model.ICreature;
import model.Maps;
import model.MyPosition;
import model.animal.Huou;
import model.animal.Lion;
import model.animal.Wolf;
import model.plant.Grass;
import model.plant.Plant;
import actions.HuouAction;
import actions.LionAction;
import actions.WolfAction;
import api.MapLoader;

public class EnvironmentPanel extends JPanel {

	private static final long serialVersionUID = 0xAC1L;
	private Maps maps;
	private JLabel[][] lblMap;

	private List<Timer> listTimerLion;
	private List<Timer> listTimerWolf;
	private List<Timer> listTimerHuou;

	public EnvironmentPanel() {
		String sep = File.separator;
		String mapFile = System.getProperty("user.dir") + sep + "environment" + sep + "map1.map";

		newComps();
		createMap(mapFile);
		setOwnLayout();
		startActions();
	}

	private void newComps() {
		listTimerHuou = new ArrayList<Timer>();
		listTimerLion = new ArrayList<Timer>();
		listTimerWolf = new ArrayList<Timer>();
	}

	private void startActions() {
		for (Timer timer : listTimerLion) {
			timer.start();
		}

		for (Timer timer : listTimerWolf) {
			timer.start();
		}

		for (Timer timer : listTimerHuou) {
			timer.start();
		}
	}

	private void createMap(String mapFile) {
		maps = MapLoader.loadMapFrom(mapFile);

		if (maps != null) {
			ICreature[][] map = maps.getMap();
			lblMap = new JLabel[map.length][map[0].length];

			for (int y = 0; y < map.length; y++) {
				for (int x = 0; x < map[y].length; x++) {
					JLabel lbl = new JLabel(map[y][x].toString());
					lbl.setPreferredSize(new Dimension(65, 75));
					lbl.setSize(lbl.getPreferredSize());

					if (map[y][x] instanceof Lion) {

						lbl.setForeground(IColor.LION);
						listTimerLion.add(new Timer(1000, new LionAction(this, (Lion) map[y][x])));

					} else if (map[y][x] instanceof Wolf) {

						lbl.setForeground(IColor.WOLF);
						listTimerWolf.add(new Timer(700, new WolfAction(this, (Wolf) map[y][x])));

					} else if (map[y][x] instanceof Huou) {

						lbl.setForeground(IColor.HUOU);
						listTimerHuou.add(new Timer(800, new HuouAction(this, (Huou) map[y][x])));

					} else if (map[y][x] instanceof Plant) {

						lbl.setForeground(IColor.PLANT);

					} else if (map[y][x] instanceof Grass) {

						lbl.setForeground(IColor.GRASS);

					}

					lblMap[y][x] = lbl;
				}
			}
		}
	}

	private void setOwnLayout() {
		this.setLayout(null);

		int height = lblMap[0][0].getHeight() * lblMap.length;
		int width = lblMap[0][0].getWidth() * lblMap[0].length;

		this.setPreferredSize(new Dimension(width, height));
		this.setSize(this.getPreferredSize());
		for (int y = 0; y < lblMap.length; y++) {
			for (int x = 0; x < lblMap[y].length; x++) {
				this.add(lblMap[y][x]);
				JLabel lbl = lblMap[y][x];
				lblMap[y][x].setBounds(lbl.getWidth() * x, lbl.getHeight() * y, lbl.getWidth(), lbl.getHeight());
			}
		}
	}

	public Maps getMaps() {
		return maps;
	}

	public void setMaps(Maps maps) {
		this.maps = maps;
	}

	public JLabel[][] getLblMap() {
		return lblMap;
	}

	public void setLblMap(JLabel[][] lblMap) {
		this.lblMap = lblMap;
	}

	public void updateText(MyPosition p1, MyPosition p2) {
		int x1 = p1.getX();
		int y1 = p1.getY();

		int x2 = p2.getX();
		int y2 = p2.getY();

		Color tmp = lblMap[y1][x1].getForeground();
		lblMap[y1][x1].setForeground(lblMap[y2][x2].getForeground());
		lblMap[y2][x2].setForeground(tmp);

		lblMap[y1][x1].setText(maps.getCreatureAt(p1).toString());
		lblMap[y2][x2].setText(maps.getCreatureAt(p2).toString());

	}
}
