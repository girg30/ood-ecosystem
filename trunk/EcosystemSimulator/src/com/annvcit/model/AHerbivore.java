package com.annvcit.model;

import java.util.ArrayList;
import java.util.List;

import com.annvcit.util.Util;

/**
 * lớp cha của các loài thực vật
 */
public abstract class AHerbivore extends AAnimal {
	public AHerbivore(int x, int y) { 
		super(x, y); 
		radius = 200;
	}
	
	public AHerbivore() {} 
	
	public void goEat(List<APlant> plantList) {
		int step = 2;
		List<APlant> victimList = findPlant(plantList);
		APlant victim = nearestPlant(victimList);
	
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
			Message messageEat = new Message(Message.EAT);
			setChanged();
			notifyObservers(messageEat, this, victim);
			
		}
	
		Util.setDelay(speed);
		
	}

	public List<APlant> findPlant(List<APlant> plantList) {
		List<APlant> victimList = new ArrayList<>();

		for (APlant a : plantList) {
			if (this.radiusBound.intersects(a.getBody())) {
				victimList.add(a);
			}
		}
		return victimList;
	}

	public APlant nearestPlant(List<APlant> plantList) {
		double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		APlant plant = null;
		for (int i = 0; i < plantList.size(); i++) {
			distance = Util.distance(this.body, plantList.get(i).getBody());
			if (distance < minDistance) {
				minDistance = distance;
				plant = plantList.get(i);
			}
		}
		return plant;
	}
    
	public void goBreed(List<AHerbivore> oppositeSexAnimal) {
    	int step = 2;
		List<AHerbivore> partnerList = findOppositeAnimal(oppositeSexAnimal);
		AHerbivore partner = nearestOppositeSexAnimal(partnerList);
	
		if (partner == null) {
			return;
		}
	
		int partnerX = partner.getBody().x;
		int partnerY = partner.getBody().y;
	
		if (partnerX < body.x) {
			this.body.x -= step;
		}else if (partnerX > body.x) {
			this.body.x += step;
		}
	
		if (partnerY < body.y) {
			this.body.y -= step;
		}else if (partnerY > body.y) {
			this.body.y += step;
		}
	
		if (body.intersects(partner.getBody())) {
			Message messageHunt = new Message(Message.MAKE_BABY);
			setChanged();
			notifyObservers(messageHunt, this, partner);
		}
	
		Util.setDelay(speed);
    }
	
	public AHerbivore nearestOppositeSexAnimal(List<AHerbivore> partnerList) {
    	double distance = 0;
		double minDistance = Integer.MAX_VALUE;
		AHerbivore partner = null;
		for (int i = 0; i < partnerList.size(); i++) {
			if(!this.equals(partnerList.get(i))){
				if (this.isOppositeSex(partnerList.get(i))) {
					distance = Util.distance(this.body, partnerList.get(i).getBody());
					if (distance < minDistance) {
						minDistance = distance;
						partner = partnerList.get(i);
					}
				}
			}
		}
		if (partner == null) this.setCurrentState(this.getStarvedState());
		return partner;
    }
    
    public List<AHerbivore> findOppositeAnimal(List<AHerbivore> inRadiusBound){
    	List<AHerbivore> partnerList = new ArrayList<>();

		for (AHerbivore a : inRadiusBound) {
			if (this.radiusBound.intersects(a.getBody())) {
				partnerList.add(a);
			}
		}
		return partnerList;
    }
}
