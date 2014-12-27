package com.annvcit.model;

/**
 * tạo các sinh vật thành phần cho Ecosystem
 * */
public interface ICreatureFactory {
	
	ACarnivore createCarnivore();
	AHerbivore createHerbivore();
	APlant createPlant();
}
