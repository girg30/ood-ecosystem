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
        
        IAnimalState a1State = a1.getCurrentState();
        IAnimalState a2State = a2.getCurrentState();
        
        /*
         * Cả 2 con cùng là đv ăn thịt hoặc
         * cùng là đv ăn cỏ
         * */
        if (a1 instanceof ACarnivore && a2 instanceof ACarnivore ||
                a1 instanceof AHerbivore && a2 instanceof AHerbivore) {
            if (a1State instanceof ImplStarvedState &&
                    a2State instanceof ImplStarvedState) {
                return new ImplFightInteraction();
            } else if (a1.isOppositeSex(a2)) {
                return new ImplBreedInteraction();
            }
        }
        return new ImplNothingTakePlaceInteraction();
    }

    public IInteraction chInteraction(ACarnivore aCarnivore,
            AHerbivore aHerbivore) {
        return new ImplNothingTakePlaceInteraction();
    }

    public IInteraction hpInteraction(AHerbivore aHerbivore, APlant aPlant) {
        return new ImplNothingTakePlaceInteraction();
    }

}
