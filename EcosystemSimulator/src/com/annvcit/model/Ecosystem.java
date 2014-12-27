package com.annvcit.model;


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
