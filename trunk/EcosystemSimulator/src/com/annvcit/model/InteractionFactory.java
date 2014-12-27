package com.annvcit.model;

/**
 * Lớp quản lý tương tác của các sinh vật
 * */
public class InteractionFactory {
	
	/**
	 * tương tác giữa đv ăn thịt vs đv ăn thịt
	 * hoặc
	 * đv ăn cỏ vs đv ăn cỏ
	 * 
	 * */
	public IInteraction cchhInteraction(AAnimal... animals) {
      return null;
   }
   
	/**
	 * tương tác giữa đv ăn thịt & đv ăn cỏ
	 * */
   public IInteraction chInteraction(ACarnivore aCarnivore, AHerbivore aHerbivore) {
	   return null;
   }
   
   /**
    * tương tác giữa đv ăn cỏ và thực vật
    * */
   public IInteraction hpInteraction(AHerbivore aHerbivore, APlant aPlant) {
	   return null;
   }
   
   	
}
