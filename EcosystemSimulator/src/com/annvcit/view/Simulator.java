package com.annvcit.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.annvcit.controller.ICreatureFactory;
import com.annvcit.controller.ImplAfricaFactory;

public class Simulator extends JPanel implements KeyListener {
	private static final long serialVersionUID = -433666434252405672L;
	
	private ICreatureFactory creatureFactory;
	
	public Simulator() {
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		addKeyListener(this);
		
		creatureFactory = new ImplAfricaFactory(10, 110);
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(99, 68, 29));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		creatureFactory.drawAnimals(g);
		creatureFactory.askCarnivoreMove();
		creatureFactory.askHerbivoreMove();
		
		g.dispose(); // release resource
		repaint();
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	//********************************
    //       IMPLEMENT METHODS       *
    //********************************

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		if (c == KeyEvent.VK_UP) {}
		
		if (c == KeyEvent.VK_DOWN) {}
		
		if (c == KeyEvent.VK_LEFT) {}
		
		if (c == KeyEvent.VK_RIGHT) {}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		Simulator sim = new Simulator();
		JFrame game = new JFrame();
		
		game.add(sim);
		game.pack();
		
		game.setTitle("Ecosystem Simulator");
		game.setResizable(false);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);
		game.setVisible(true);
	}
}
