package com.annvcit.model;

/**
 * nhà máy tạo sinh vật cho Africa
 * */

public class ImplAfricaFacotry implements ICreatureFactory {

	@Override
	public ACarnivore createCarnivore() {
		return new Lion();
	}

	@Override
	public AHerbivore createHerbivore() {
		return new Antelope();
	}

	@Override
	public APlant createPlant() {
		return new Grass();
	}
}
