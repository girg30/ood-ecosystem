package com.annvcit.model;

/**
 * Trạng thái chết đói (đói muốn chết) của sinh vật
 * */
public class ImplStarvedState implements IAnimalState {

	private AAnimal animal;
	
	public ImplStarvedState(AAnimal a) {
		animal = a;
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
