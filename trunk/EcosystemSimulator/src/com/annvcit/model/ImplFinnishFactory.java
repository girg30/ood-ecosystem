package com.annvcit.model;

/**
 * nhà máy tạo sinh vật cho môi trường ở Finnish
 * */
public class ImplFinnishFactory implements ICreatureFactory {

	@Override
	public ACarnivore createCarnivore() {
		return new Wolf();
	}

	@Override
	public AHerbivore createHerbivore() {
		return new Rabbit();
	}

	@Override
	public APlant createPlant() {
		return new Willow();
	}
}
