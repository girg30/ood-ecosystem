package com.annvcit.model;


public interface ICreatureFactory {
	
	ACarnivore createCarnivore();
	AHerbivore createHerbivore();
	APlant createPlant();
}
