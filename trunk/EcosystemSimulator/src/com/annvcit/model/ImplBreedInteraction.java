package com.annvcit.model;

import java.util.Random;

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
        int x = (male.x + female.x)/2;
        int y = (male.y + female.y)/2;
        int width = 8;
        int height = 8;
        
        if (male instanceof Lion && female instanceof Lion) child = new Lion(x,y);
        if (male instanceof Wolf && female instanceof Wolf) child = new Wolf();
        if (male instanceof Antelope && female instanceof Antelope) child = new Antelope(x,y);
        if (male instanceof Rabbit && female instanceof Rabbit) child = new Rabbit();
        
        child.getBody().width = width;
        child.getBody().height = height;
        child.setRadius(100);
        child.isChild(true);
        Random random = new Random();
        if (random.nextInt(2) == 1) child.setSex(AAnimal.MALE);
        else child.setSex(AAnimal.FEMALE);
        
        System.out.println(child.radiusBound == null);
        System.out.println(child.body == null);
        		
        
        male.setCurrentState(male.getNormalState());
        female.setCurrentState(female.getNormalState());
        
        male.setWantBreed(-10);
        female.setWantBreed(-10);
        
        return child;
    }
    
    
}
