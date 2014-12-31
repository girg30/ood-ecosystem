package com.annvcit.model;


/**
 * t?o c�c sinh v?t th�nh ph?n cho Ecosystem
 *  *
 */
public interface ICreatureFactory {
   public ACarnivore createCarnivore();
   
   public AHerbivore createHerbivore();
   
   public APlant createPlant();
   
   }
