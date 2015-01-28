package com.annvcit.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;
import com.annvcit.model.Antelope;
import com.annvcit.model.Grass;
import com.annvcit.model.ImplHungryState;
import com.annvcit.model.Lion;
import com.annvcit.model.InteractionFactory;
import com.annvcit.model.Message;

import com.annvcit.util.Observer;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần cụ thể cần
 * cho 1 hệ sinh thái cụ thể. Ở đây là Africa
 */
public class ImplAfricaFactory implements ICreatureFactory, Observer {

	private List<Lion> lionList;
	private List<Antelope> antelopeList;
	private InteractionFactory interactionFactory;

	Random random = new Random();

	public ImplAfricaFactory() {}
	
	public ImplAfricaFactory(int lions, int antelopes) {
		lionList = new ArrayList<>();
		antelopeList = new ArrayList<>();
		interactionFactory = new InteractionFactory();
		
		int numSex = -1;
		int numState = -1;
		
		// initialize objects
		for (int i = 0; i < lions; i++) {
			Lion lion = new Lion(random.nextInt(800), random.nextInt(600));
			
			numSex = random.nextInt(3);
			numState = random.nextInt(3);
			
			lion.setSex('m');
			if (numSex > 1) lion.setSex('f');
			
			if (numState > 1) lion.setCurrentState(lion.getHungryState());
			
			lion.addObserver(this);
			lionList.add(lion);
			
		}

		for (int i = 0; i < antelopes; i++) {
			Antelope antelope = new Antelope(random.nextInt(800), random
					.nextInt(600));
			antelopeList.add(antelope);
		}

	}

	@Override
	public void drawAnimals(Graphics g) {
		for (Antelope antelope : antelopeList) {
			antelope.draw(g);
		}
		for (Lion lion : lionList) {
			lion.draw(g);
		}
		
		g.setColor(Color.WHITE);
		g.drawString("amount of Antelope: " + antelopeList.size() , 20, 20);
		g.drawString("amount of Lion: " + lionList.size() , 20, 40);

	}
	
	public void askCarnivoreMove() {
		for (Lion lion : lionList) {
			if (lion.getCurrentState() instanceof ImplHungryState) {
				lion.goHunt(this.antelopeList);
			}
		}
	}
	
	@Override
	public void update(Object... objects) {
		Message message = (Message) objects[0];
		Lion lion = (Lion) objects[1];
		Antelope antelope = (Antelope) objects[2];
		switch (message.getContent()) {
		case Message.HUNT:
			interactionFactory.chInteraction(lion, antelope).interact();
			antelopeList.remove(antelope);
			System.out.println(lion.getCurrentState());
			break;
		}
	}
	
	@Override
	public ACarnivore createCarnivore() {
		return new Lion(random.nextInt(800), random.nextInt(600));
	}

	@Override
	public AHerbivore createHerbivore() {
		return new Antelope(random.nextInt(800), random.nextInt(600));
	}

	@Override
	public APlant createPlant() {
		return new Grass();
	}

	public List<Antelope> getAntelopeList() { return this.antelopeList; }
	
}
