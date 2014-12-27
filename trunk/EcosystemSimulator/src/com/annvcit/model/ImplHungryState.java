package com.annvcit.model;

/**
 * trạng thái đói của sinh vật (đói bình thường)
 * */
public class ImplHungryState implements IAnimalState {

	private AAnimal animal;
	
	public ImplHungryState(AAnimal a) {
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
