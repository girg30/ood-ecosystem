package run;

import gui.EnvironmentPanel;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	private EnvironmentPanel ePanel;

	public Main() {
		init();
	}

	private void init() {

		ePanel = new EnvironmentPanel();
		this.getContentPane().setLayout(null);
		getContentPane().add(ePanel);
		ePanel.setBounds(0, 0, ePanel.getWidth(), ePanel.getHeight());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1366, 768);
		this.setTitle("Ecosystem - created by TNu\'");
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Main();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// String sep = File.separator;
		// String mapOut = System.getProperty("user.dir") + sep + "environment" + sep + "map1.map";
		// System.out.println(MapLoader.saveMapTo(MapGenerator.createRandomMap(20, 10), mapOut));
		// MapGenerator.printMap(MapLoader.loadMapFrom(mapOut));
	}
}