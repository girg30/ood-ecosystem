package com.annvcit.model;

/**
 * trạng thái bình thường của sinh vật
 * */
public class ImplNormalState implements IAnimalState {

	private AAnimal animal;
	
	public ImplNormalState(AAnimal a) {
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
