package com.annvcit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.annvcit.model.Message;
import com.annvcit.util.Observable;
import com.annvcit.util.Observer;
import com.annvcit.view.FrameSimulator;
import com.annvcit.view.Home;

/**
 * nối bên Home (view) và bên model
 * */
public class HomeEvent implements ActionListener, Observable {

	private Home home;
	private FrameSimulator simGUI;
	private boolean isChanged = false;

	private Observer obs;

	public HomeEvent(Home h) {
		this.home = h;
		simGUI = new FrameSimulator();
		addObserver(simGUI.getSimulator());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == home.getRbtnAfrican()) {
			changeToAfrican(e);
		} else if (e.getSource() == home.getRbtnFinnish()) {
			changeToFinnish(e);
		} else if(e.getSource() == home.getStartButton()){
			startGUI();
		}

	}

	private void startGUI() {
		simGUI.setVisible(true);
	}

	/** chuyển môi trường qua african */
	private void changeToAfrican(ActionEvent e) {
//		Ecosystem african = new Ecosystem(new ImplAfricaFactory());
		setChanged();
		notifyObservers(Message.AFRICA_ENV);
	}

	/** chuyển môi trường qua finnish */
	private void changeToFinnish(ActionEvent e) {
//		Ecosystem finnish = new Ecosystem(new ImplFinnishFactory());
		setChanged();
		notifyObservers(Message.FINNISH_ENV);
	}

	@Override
	public void addObserver(Observer observer) {
		obs = observer;
	}

	@Override
	public void removeObserver(Observer observer) {
		obs = null;
	}

	@Override
	public void notifyObservers(Object... objects) {
		if(isChanged){
			obs.update(objects);
		}
		isChanged = false;
	}

	@Override
	public void setChanged() {
		isChanged = true;
	}

}
