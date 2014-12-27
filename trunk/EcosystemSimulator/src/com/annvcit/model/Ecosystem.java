package com.annvcit.model;

/**
 * hệ sinh thái :)
 * */
public class Ecosystem {
   private AHerbivore herbivore;
   private APlant plant;
   private ACarnivore carnivore;
   public Ecosystem (ICreatureFactory fact) {
      carnivore = fact.createCarnivore();
      		herbivore = fact.createHerbivore();
      		plant = fact.createPlant();
      	}
   
   }
