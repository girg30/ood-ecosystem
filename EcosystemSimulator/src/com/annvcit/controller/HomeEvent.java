package com.annvcit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.annvcit.model.AEcosystem;
import com.annvcit.model.ImplAfricaFacotry;
import com.annvcit.model.ImplFinnishFactory;
import com.annvcit.view.Home;

public class HomeEvent implements ActionListener{

	private Home home;
	
	public HomeEvent(Home h) {
		this.home = h;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == home.getRbtnAfrican()) {
			changeToAfrican(e);
		} else if (e.getSource() == home.getRbtnFinnish()) {
			changeToFinnish(e);
		}
		
	}
	
	// chuyển môi trường qua african
	private void changeToAfrican(ActionEvent e) {
		AEcosystem african = new AEcosystem(new ImplAfricaFacotry());
	}
	
	// chuyển môi trường qua finnish
	private void changeToFinnish(ActionEvent e) {
		AEcosystem finnish = new AEcosystem(new ImplFinnishFactory());
	}
	
}
