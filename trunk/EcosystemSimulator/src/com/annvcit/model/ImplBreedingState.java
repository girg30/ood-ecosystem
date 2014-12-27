package com.annvcit.model;

public class ImplBreedingState implements IAnimalState {

	private AAnimal animal;
	
	public ImplBreedingState(AAnimal animal) {
		this.animal = animal;
	}

	@Override
	public void fight(AAnimal... animals) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chase(ACarnivore hunter, AHerbivore victim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breed(AAnimal... animals) {
		// TODO Auto-generated method stub
		
	}
	
	
}
