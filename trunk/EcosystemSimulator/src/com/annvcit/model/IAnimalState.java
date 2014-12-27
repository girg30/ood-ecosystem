package com.annvcit.model;

/**
 * interface định nghĩa các trạng thái của động vật
 * */
public interface IAnimalState {
	
	void fight(AAnimal...animals);
	void chase(ACarnivore hunter, AHerbivore victim);
	void breed(AAnimal...animals);
	
}
