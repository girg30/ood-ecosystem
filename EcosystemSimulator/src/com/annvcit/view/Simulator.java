package com.annvcit.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.annvcit.controller.ICreatureFactory;
import com.annvcit.controller.ImplAfricaFactory;
import com.annvcit.controller.ImplFinnishFactory;
import com.annvcit.model.Message;
import com.annvcit.util.Observer;

public class Simulator extends JPanel implements KeyListener, Observer {
	private static final long serialVersionUID = -433666434252405672L;
	
	private ICreatureFactory africaFactory;
	private ICreatureFactory finnishFactory;
	
	private String envName = Message.AFRICA_ENV;
	
	public Simulator() {
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		addKeyListener(this);
		
		africaFactory = new ImplAfricaFactory(7,  15, 30);
		finnishFactory = new ImplFinnishFactory(7,15,30);
		//finnish
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(99, 68, 29));
		g.fillRect(0, 0, getWidth(), getHeight());
		switch(envName){
		case Message.AFRICA_ENV:
			drawAfricaEnvironment(g);
			break;
		case Message.FINNISH_ENV:
			drawFinnishEnvironment(g);
			break;
		}
		
		g.dispose(); // release resource
		repaint();
	}
	
	private void drawAfricaEnvironment(Graphics g){
		africaFactory.drawBackground(g);
		africaFactory.draw(g);
		africaFactory.askCarnivoreMove();
		africaFactory.askHerbivoreMove();
	}
	
	private void drawFinnishEnvironment(Graphics g){
		finnishFactory.drawBackground(g);
		finnishFactory.draw(g);
		finnishFactory.askCarnivoreMove();
		finnishFactory.askHerbivoreMove();
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

	@Override
	public void update(Object... objects) {
		envName = (String)objects[0];
	}
}
