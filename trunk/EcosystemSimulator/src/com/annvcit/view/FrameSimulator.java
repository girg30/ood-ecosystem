package com.annvcit.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameSimulator extends JFrame{

	private static final long serialVersionUID = 1L;
	private Simulator sim;
	
	public FrameSimulator() {
		sim = new Simulator();
		
		this.add(sim);
		this.pack();
		
		this.setTitle("Ecosystem Simulator");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				setVisible(false);
			}
		});
		
	}
	
	public Simulator getSimulator(){
		return this.sim;
	}
}
