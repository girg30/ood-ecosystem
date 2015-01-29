package com.annvcit.model;

import java.util.ArrayList;
import java.util.List;

import com.annvcit.util.Util;


/**
 * lớp cha của các loài đv ăn thịt
 */
public abstract class ACarnivore extends AAnimal {

	public ACarnivore(int x, int y) { 
		super(x, y); 
		radius = 800;
	}
	
	public ACarnivore() {}
	
	public List<AHerbivore> findVictim(List<AHerbivore> antelopeList) {

		List<AHerbivore> victimList = new ArrayList<>();

		for (AHerbivore a : antelopeList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}
	
	public List<ACarnivore> findCarnivore(List<ACarnivore> carnivoreList) {

		List<ACarnivore> victimList = new ArrayList<>();

		for (ACarnivore a : carnivoreList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}
	
	public ACarnivore nearestCarnivore(List<ACarnivore> carnivoreList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		ACarnivore carnivore = null;
		for (int i = 0; i < carnivoreList.size(); i++) {
			if(!this.equals(carnivoreList.get(i))){
				distance = Util.distance(this.body, carnivoreList.get(i).getBody());
				if (distance < minDistance) {
					minDistance = distance;
					carnivore = carnivoreList.get(i);
				}
			}
		}
		return carnivore;
	}

	public AHerbivore nearestVictim(List<AHerbivore> herbivoreList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		AHerbivore antelope = null;
		for (int i = 0; i < herbivoreList.size(); i++) {
			distance = Util.distance(this.body, herbivoreList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				antelope = herbivoreList.get(i);
			}
		}
		return antelope;
	}
	

	public void goHunt(List<AHerbivore> antelopeList) {
		int step = 2;
		List<AHerbivore> victimList = findVictim(antelopeList);
		AHerbivore victim = nearestVictim(victimList);
	
		if (victim == null)
			return;
	
		int victimX = victim.getBody().x;
		int victimY = victim.getBody().y;
	
		if (victimX < body.x) {
			this.body.x -= step;
		}else if (victimX > body.x) {
			this.body.x += step;
		}
	
		if (victimY < body.y) {
			this.body.y -= step;
		}else if (victimY > body.y) {
			this.body.y += step;
		}
	
		if (body.intersects(victim.getBody())) {
			Message messageHunt = new Message(Message.HUNT);
			setChanged();
			notifyObservers(messageHunt, this, victim);
			
		}
	
		setDelay(speed);
	}
	
	public void goFight(List<ACarnivore> cannivoreList){ 
		System.out.println("vo con");
		int step = 2;
		List<ACarnivore> victimList = findCarnivore(cannivoreList);
		ACarnivore victim = nearestCarnivore(victimList);
	
		if (victim == null)
			return;
	
		int victimX = victim.getBody().x;
		int victimY = victim.getBody().y;
	
		if (victimX < body.x) {
			this.body.x -= step;
		}else if (victimX > body.x) {
			this.body.x += step;
		}
	
		if (victimY < body.y) {
			this.body.y -= step;
		}else if (victimY > body.y) {
			this.body.y += step;
		}
	
		if (body.intersects(victim.getBody())) {
			Message messageHunt = new Message(Message.FIGHT_ME);
			setChanged();
			notifyObservers(messageHunt, this, victim);
		}
	
		setDelay(speed);
	}
	
	@Override
	public boolean equals(Object o){
		ACarnivore other = (ACarnivore)o;
		return this.hashCode() == other.hashCode();
	}
}
