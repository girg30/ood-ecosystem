package com.annvcit.model;


/**
 * nh� m�y t?o sinh v?t cho m�i tr??ng ? Finnish
 *  *
 */
public class ImplFinnishFactory implements ICreatureFactory {
   @Override
   public ACarnivore createCarnivore () 
   {
      return new Wolf();
      	}
   @Override
   public AHerbivore createHerbivore () 
   {
      return new Rabbit();
      	}
   @Override
   public APlant createPlant () 
   {
      return new Willow();
      	}
   }
