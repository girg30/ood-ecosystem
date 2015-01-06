package com.annvcit.model;

/**
 * Nhà máy tao tương tác.
 * Ứng với mỗi trường hợp thì sẽ có 1 phương thức tương ứng.
 */
public class InteractionFactory {
    
    public IInteraction cchhInteraction(AAnimal... animals) {}

    public IInteraction chInteraction(ACarnivore aCarnivore,
            AHerbivore aHerbivore) {}

    public IInteraction hpInteraction(AHerbivore aHerbivore, APlant aPlant) {}

}
