package com.annvcit.model;

import java.util.List;


/**
 * lớp cha của các loài đv ăn thịt
 */
public abstract class ACarnivore extends AAnimal {

	public ACarnivore(int x, int y) { 
		super(x, y); 
	}
	
	public ACarnivore() {}
	
	protected abstract void goHunt(List<AHerbivore> herbivoreList);
    protected abstract List<AHerbivore> findVictim(List<AHerbivore> herbivoreList);
    protected abstract AHerbivore nearestVictim(List<AHerbivore> victimList);
}
