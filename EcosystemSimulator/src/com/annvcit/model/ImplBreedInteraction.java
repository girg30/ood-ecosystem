package com.annvcit.model;

/**
 * Tương tác sinh sản giữa 2 con động vật opposite sex
 * */
public class ImplBreedInteraction implements IInteraction {
    
    private AAnimal female;
    private AAnimal male;
    
    public ImplBreedInteraction(AAnimal f, AAnimal m) {
        this.female = f;
        this.male = m;
    }

    @Override
    public Object interact() {
        AAnimal child = null;
        if (male instanceof Lion && female instanceof Lion) child = new Lion();
        if (male instanceof Wolf && female instanceof Wolf) child = new Wolf();
        if (male instanceof Antelope && female instanceof Antelope) child = new Antelope();
        if (male instanceof Rabbit && female instanceof Rabbit) child = new Rabbit();
        return child;
    }
    
    
}
