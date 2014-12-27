package com.annvcit.model;

/**
 * lớp cha của đv ăn thịt và ăn cỏ => động vật =]]
 * */
public abstract class AAnimal {
	protected IAnimalState starvedState;
	protected IAnimalState hungryState;
	protected IAnimalState breedingState;
	protected IAnimalState normalState;
	
}
