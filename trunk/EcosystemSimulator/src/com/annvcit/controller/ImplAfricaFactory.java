package com.annvcit.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;//avoid ConcurrentModificationException

import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;
import com.annvcit.model.Antelope;
import com.annvcit.model.Grass;
import com.annvcit.model.ImplHungryState;
import com.annvcit.model.ImplStarvedState;
import com.annvcit.model.InteractionFactory;
import com.annvcit.model.Lion;
import com.annvcit.model.Message;
import com.annvcit.util.Observer;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần cụ thể cần
 * cho 1 hệ sinh thái cụ thể. Ở đây là Africa
 */
public class ImplAfricaFactory implements ICreatureFactory, Observer {

	private List<ACarnivore> lionList;
	private List<AHerbivore> antelopeList;
	private List<APlant> grassList;
	
	private InteractionFactory interactionFactory;
	
	Random random = new Random();

	public ImplAfricaFactory() {}
	
	public ImplAfricaFactory(int lions, int antelopes, int grasses) {
		interactionFactory = new InteractionFactory();
		lionList = new CopyOnWriteArrayList<>();
		antelopeList = new CopyOnWriteArrayList<>();
		grassList = new CopyOnWriteArrayList<>();

		int numSex = -1;
		int numState = -1;
		
		// initialize objects
		for (int i = 0; i < lions; i++) {
			Lion lion = new Lion(random.nextInt(800), random.nextInt(600));
			
			numSex = random.nextInt(2);
			numState = random.nextInt(2);
			
			lion.setSex('m');
			if (numSex == 1) lion.setSex('f');
			
			lion.setCurrentState(lion.getNormalState());
			if (numState == 1) lion.setCurrentState(lion.getHungryState());
			
			lion.addObserver(this);
			lionList.add(lion);
			
		}

		for (int i = 0; i < antelopes; i++) {
			Antelope antelope = new Antelope(random.nextInt(800), random
					.nextInt(600));
			
			numSex = random.nextInt(2);
			numState = random.nextInt(2);
			
			antelope.setSex('m');
			if (numSex == 1) antelope.setSex('f');
			
			antelope.setCurrentState(antelope.getNormalState());
			if (numState == 1) antelope.setCurrentState(antelope.getHungryState());
			
			antelope.setPower(random.nextInt(900) + 300);
			antelope.addObserver(this);
			antelopeList.add(antelope);
		}
		
		for (int i = 0; i < grasses; i++) {
			APlant grass = new Grass(random.nextInt(800), random.nextInt(600));
			grass.addObserver(this);
			grassList.add(grass);
		}

	}

	@Override
	public void draw(Graphics g) {
		respawn();
		for (APlant grass : grassList) grass.draw(g);
		
		Iterator<ACarnivore> iteratorLion = lionList.iterator();
		while (iteratorLion.hasNext()) {
			Lion lion = ((Lion) iteratorLion.next());
			lion.draw(g);
		}
		
		Iterator<AHerbivore> iteratorAntelope = antelopeList.iterator();
		while (iteratorAntelope.hasNext()) {
			Antelope antelope = ((Antelope) iteratorAntelope.next());
			antelope.draw(g);
			
		}
		
		g.setColor(Color.WHITE);
		g.drawString("amount of Antelope: " + antelopeList.size() , 20, 20);
		g.drawString("amount of Lion: " + lionList.size() , 20, 40);
		g.drawString("amount of Grass: " + grassList.size() , 20, 60);

	}
	
	public void askCarnivoreMove() {
		for (ACarnivore lion : lionList) {
			if (lion.getCurrentState() instanceof ImplHungryState) {
				lion.goHunt(this.antelopeList);
			} else if (lion.getCurrentState() instanceof ImplStarvedState) {
				lion.goFight(lionList);
			}
		}
	}
	
	@Override
	public void askHerbivoreMove() {
		for (AHerbivore antelope : antelopeList) {
			if (antelope.getCurrentState() instanceof ImplHungryState) {
				antelope.goEat(this.grassList);
			}
		}
	}
	
	@Override
	public void update(Object... objects) {
		Message message = (Message) objects[0];
		
		
		switch (message.getContent()) {
		case Message.HUNT:
			Lion lion = (Lion) objects[1];
			Antelope antelope = (Antelope) objects[2];
			
			interactionFactory.chInteraction(lion, antelope).interact();
			antelope.removeObserver(this);
			antelopeList.remove(antelope);
			break;
		case Message.EAT:
			antelope = (Antelope) objects[1];
			Grass grass = (Grass) objects[2];
			interactionFactory.hpInteraction(antelope, grass).interact();
			grass.removeObserver(this);
			grassList.remove(grass);
			break;
			
		case Message.REMOVE_ME:
			Object o = objects[1];
			if (o instanceof Lion) {
				((Lion) o).removeObserver(this);
				lionList.remove(o);
			}
			if (o instanceof Antelope) {
				((Antelope) o).removeObserver(this);
				antelopeList.remove(o);
			}
			break;
		case Message.FIGHT_ME:
			ACarnivore lion1 = (ACarnivore) objects[1];
			ACarnivore lion2 = (ACarnivore) objects[2];
			
			ACarnivore victim = (ACarnivore)interactionFactory.cchhInteraction(lion1,lion2).interact();
			
			victim.removeObserver(this);
			lionList.remove(victim);
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

	public List<AHerbivore> getAntelopeList() { return this.antelopeList; }
	
	public void respawn() {
		int lionListSize = lionList.size();
		int antelopeListSize = antelopeList.size();
		int grassListSize = grassList.size();
		
		int numSex = -1;
		int numState = -1;
		
		if (lionListSize < 2) {
			for (int i = 0; i < 5; i++) {
				Lion lion = new Lion(random.nextInt(800), random.nextInt(600));
				
				numSex = random.nextInt(2);
				numState = random.nextInt(2);
				
				lion.setSex('m');
				if (numSex == 1) lion.setSex('f');
				
				lion.setCurrentState(lion.getNormalState());
				if (numState == 1) lion.setCurrentState(lion.getHungryState());
				
				lion.addObserver(this);
				lionList.add(lion);
				
			}
		}
		
		if (antelopeListSize < 4) {
			for (int i = 0; i < 7; i++) {
				Antelope antelope = new Antelope(random.nextInt(800), random
						.nextInt(600));
				
				numSex = random.nextInt(2);
				numState = random.nextInt(2);
				
				antelope.setSex('m');
				if (numSex == 1) antelope.setSex('f');
				
				antelope.setCurrentState(antelope.getNormalState());
				if (numState == 1) antelope.setCurrentState(antelope.getHungryState());
				
				antelope.setPower(random.nextInt(900) + 300);
				antelope.addObserver(this);
				antelopeList.add(antelope);
			}
		}
		
		if (grassListSize < 7) {
			for (int i = 0; i < 15; i++) {
				APlant grass = new Grass(random.nextInt(800), random.nextInt(600));
				grass.addObserver(this);
				grassList.add(grass);
			}
		}
	}
	
}
