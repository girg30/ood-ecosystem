package com.annvcit.model;


public class AEcosystem {
	
	private ACarnivore carnivore;
	private AHerbivore herbivore;
	private APlant plant;
	
	public AEcosystem(ICreatureFactory fact) {
		carnivore = fact.createCarnivore();
		herbivore = fact.createHerbivore();
		plant = fact.createPlant();
	}

}
