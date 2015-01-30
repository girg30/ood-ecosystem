package com.annvcit.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class DemoMoveMap extends JPanel implements KeyListener {

	private int x, y;

	public DemoMoveMap() {
		setSize(800, 600);
		setPreferredSize(new Dimension(800, 600));

		x = 0;
		y = 0;

		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		ImageIcon icon = new ImageIcon(
				"C:/Users/Public/Pictures/Sample Pictures/Penguins.jpg");
		Image image = icon.getImage();
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(image, x, y, icon.getIconWidth(), icon.getIconHeight(), null);
		
		g.setColor(Color.blue);
		g.drawString("test hang",x+icon.getIconWidth(), y+icon.getIconHeight());
		
		repaint();
	}

	public void update(Graphics g) {
		super.update(g);
		paint(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			y+=5;
			break;
		case KeyEvent.VK_DOWN:
			y-=5;
			break;
		case KeyEvent.VK_LEFT:
			x+=5;
			break;
		case KeyEvent.VK_RIGHT:
			x-=5;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		DemoMoveMap map = new DemoMoveMap();
		JFrame frame = new JFrame("test");
		frame.add(map);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setFocusable(false);
		frame.setVisible(true);
	}

}
