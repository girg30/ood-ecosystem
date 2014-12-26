package com.annvcit.model;


public abstract class AEcosystem {
	
	private ICreatureFactory factory;
	private ACarnivore canivore;
	private AHerbivore herbivore;
	private APlant plant;
	
	public AEcosystem(ICreatureFactory fact) {
		this.factory = fact;
	}

}
