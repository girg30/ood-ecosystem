package com.annvcit.model;


/**
 * t?o các sinh v?t thành ph?n cho Ecosystem
 *  *
 */
public interface ICreatureFactory {
   public ACarnivore createCarnivore();
   
   public AHerbivore createHerbivore();
   
   public APlant createPlant();
   
   }
