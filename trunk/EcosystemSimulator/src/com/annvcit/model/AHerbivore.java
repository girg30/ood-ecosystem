package com.annvcit.model;

import java.util.List;

/**
 * lớp cha của các loài thực vật
 */
public abstract class AHerbivore extends AAnimal {
	public AHerbivore(int x, int y) { 
		super(x, y); 
	}
	
	public AHerbivore() {} 
	
	public abstract void goEat(List<APlant> grassList);
	public abstract List<APlant> findPlant(List<APlant> grassList);
	public abstract APlant nearestPlant(List<APlant> victimList);
    
}
