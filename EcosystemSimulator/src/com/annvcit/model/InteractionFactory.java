package com.annvcit.model;

/**
 * Nhà máy tao tương tác. Ứng với mỗi trường hợp thì sẽ có 1 phương thức tương
 * ứng.
 */
public class InteractionFactory {

    /**
     * If a carnivore meets a carnivore or an herbivore meets an herbivore
     * either fighting, breeding or nothing takes place depending on many
     * factors like the time of the year (global resource in the simulation) and
     * the state of the animals (opposite sexes or not, starved or not …).
     */
    public IInteraction cchhInteraction(AAnimal... animals) {
        AAnimal a1 = animals[0];
        AAnimal a2 = animals[1];
        /*
         * Cả 2 con cùng là đv ăn thịt hoặc
         * cùng là đv ăn cỏ
         * */
        if (a1 instanceof ACarnivore && a2 instanceof ACarnivore ||
                a1 instanceof AHerbivore && a2 instanceof AHerbivore) {
            if (a1.getCurrentState() instanceof ImplStarvedState ||
                    a2.getCurrentState() instanceof ImplStarvedState) {
                return new ImplFightInteraction(a1, a2);
            } else if (a1.isOppositeSex(a2)) {
                return new ImplBreedInteraction(a1, a2);
            }
        }
        return new ImplNothingTakePlaceInteraction();
    }

    /**
     * If carnivore meets an herbivore, a chase or nothing will take place again 
     * depending on the state of the animals (hungry or not…). 
     * */
    public IInteraction chInteraction(ACarnivore aCarnivore,
            AHerbivore aHerbivore) {
        if (aCarnivore.getCurrentState() instanceof ImplHungryState) {
            return new ImplChaseInteraction(aCarnivore, aHerbivore);
        }
        return new ImplNothingTakePlaceInteraction();
    }

    /**
     * If an herbivore meets a plant, eating or nothing will take place.
     * */
    public IInteraction hpInteraction(AHerbivore aHerbivore, APlant aPlant) {
        if (aHerbivore.getCurrentState() instanceof ImplHungryState) {
            return new ImplEatInteraction(aHerbivore, aPlant);
        }
        return new ImplNothingTakePlaceInteraction();
    }

}