package com.annvcit.model;

/**
 * Lớp tạo ra các Interaction phù hợp
 * */
public class InteractionFactory {

    /**
     * If a carnivore meets a carnivore or an herbivore meets an herbivore either fighting, 
     * breeding or nothing takes place depending on many factors like the time of the year 
     * (global resource in the simulation) and the state of the animals 
     * (opposite sexes or not, starved or not …).
     * */
	public IInteraction cchhInteraction(AAnimal... animals) {

	    if (animals[0] instanceof ACarnivore) {
	        // TODO dư vào đề bài để đửa ra object phù hợp
	        // giả sử fight
	        return new ImplFightInteraction();
	    } else if (animals[0] instanceof AHerbivore) {
	        return new ImplFightInteraction();
	    }
	    
	    return new ImplNothingTakePlaceInteraction();
	    
	}

	public IInteraction chInteraction(ACarnivore aCarnivore,
			AHerbivore aHerbivore) {
		
	    
	    return new ImplNothingTakePlaceInteraction();
	}

	public IInteraction hpInteraction(AHerbivore aHerbivore, APlant aPlant) {
		return null;
	}

}
