package com.annvcit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.annvcit.model.Ecosystem;
import com.annvcit.view.Home;

/**
 * nối bên Home (view) và bên model
 * */
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
	
	/** chuyển môi trường qua african*/
	private void changeToAfrican(ActionEvent e) {
		Ecosystem african = new Ecosystem(new ImplAfricaFactory());
	}
	
	/** chuyển môi trường qua finnish*/
	private void changeToFinnish(ActionEvent e) {
		Ecosystem finnish = new Ecosystem(new ImplFinnishFactory());
	}
	
}
