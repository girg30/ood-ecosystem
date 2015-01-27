package com.annvcit.controller;

import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;
import com.annvcit.model.Antelope;
import com.annvcit.model.Grass;
import com.annvcit.model.Lion;
import com.annvcit.model.ImplHungryState;

import java.awt.Graphics;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần
 * cụ thể cần cho 1 hệ sinh thái cụ thể. Ở đây là Africa
 */
public class ImplAfricaFactory implements ICreatureFactory {
    
	private List<Lion> lionList;
	private List<Antelope> antelopeList;
	
	private int lion; // amount of lion
	private int antelope; // amount of antelopes
	
	Random random = new Random();
	
	public ImplAfricaFactory(int lions, int antelopes) {
		this.lion = lions;
		this.antelope = antelopes;
		
		lionList = new ArrayList<>();
		antelopeList = new ArrayList<>();
		
		// initialize objects
		for (int i = 0; i < lions - 2; i++) {
			lionList.add(new Lion(random.nextInt(800), random.nextInt(600)));
		}
		
		Lion l = new Lion(random.nextInt(800), random.nextInt(600));
		l.setCurrentState(l.getHungryState());
		lionList.add(l);
		
		Lion l1 = new Lion(random.nextInt(800), random.nextInt(600));
		l1.setCurrentState(l1.getHungryState());
		lionList.add(l1);
		
		for (int i = 0; i < antelopes; i++) {
			antelopeList.add(new Antelope(random.nextInt(800), random.nextInt(600)));
		}
		
		askCarnivoreMove();
	}
	
	public void askCarnivoreMove() {
		for (Lion lion : lionList) {
			if (lion.getCurrentState() instanceof ImplHungryState) {
				lion.findVictim(this.antelopeList);
			}
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
    
    @Override
    public void drawAnimals(Graphics g) {
    	for (Lion lion : lionList) {
    		lion.draw(g);
    	}
    	for (Antelope antelope: antelopeList) {
    		antelope.draw(g);
    	}
    }
}
