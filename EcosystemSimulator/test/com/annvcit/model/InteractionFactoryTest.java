package com.annvcit.model;

import org.junit.Test;

public class InteractionFactoryTest {

    @Test
    public void testCchhInteraction_fightBehavior() {
        System.out.println("**fight");
        InteractionFactory factory = new InteractionFactory();
        
        /*Carnivorous*/
        AAnimal lion1 = new Lion();
        lion1.setCurrentState(lion1.getStarvedState());
        
        AAnimal lion2 = new Lion();
        lion2.setCurrentState(lion2.getStarvedState());
        
        factory.cchhInteraction(lion1, lion2);
        
        /*Herbivore*/
        AAnimal antelope1 = new Antelope();
        antelope1.setCurrentState(antelope1.getStarvedState());
        
        AAnimal antelope2 = new Antelope();
        antelope2.setCurrentState(antelope2.getStarvedState());
        
        factory.cchhInteraction(antelope1, antelope2);
    }
    
    @Test
    public void testCchhInteraction_breedBehavior() {
        System.out.println("**breed");
        InteractionFactory factory = new InteractionFactory();
        
        /*Carnivorous*/
        AAnimal lion1 = new Lion();
        lion1.setSex('f');
        
        AAnimal lion2 = new Lion();
        lion2.setSex('m');
        
        factory.cchhInteraction(lion1, lion2);
        
        /*Herbivore*/
        AAnimal rabbit1 = new Rabbit();
        rabbit1.setSex('m');
        
        AAnimal rabbit2 = new Rabbit();
        rabbit2.setSex('f');
        
        factory.cchhInteraction(rabbit1, rabbit2);
        
    }
    
    @Test
    public void testCchhInteraction_nothingTakePlaceBehavior() {
        System.out.println("**nothing");
        InteractionFactory factory = new InteractionFactory();
        
        AAnimal wolf = new Wolf();
        AAnimal rabbit = new Rabbit();
        
        factory.cchhInteraction(wolf, rabbit);
    }
    
    /*
     * What happend if carnivore has starved state and meet another
     * animal has mormal state, but they're opposite sex
     * */
    @Test
    public void testCchhInteraction_extend1() {
        System.out.println("**extend 1");
        InteractionFactory factory = new InteractionFactory();
        
        AAnimal lion1 = new Lion();
        lion1.setCurrentState(lion1.getStarvedState());
        lion1.setSex('m');
        
        AAnimal lion2 = new Lion();
        lion2.setStarvedState(lion2.getNormalState());
        lion2.setSex('f');
        
        factory.cchhInteraction(lion1, lion2);
        
        /*The answer is breeding... */
        /*The same for herbivorous*/
    }
    
    @Test
    public void testChInteraction_chaseBehavior() {
        System.out.println("**chase");
        
        InteractionFactory factory = new InteractionFactory();
        
        ACarnivore wolf = new Wolf();
        wolf.setCurrentState(wolf.getHungryState());
        
        AHerbivore rabbit = new Rabbit();
        
        factory.chInteraction(wolf, rabbit);
    }
    
    @Test
    public void testChInteraction_nothingTakePlaceBehavior(){
        System.out.println("**nothing");
        
        InteractionFactory factory = new InteractionFactory();
        
        ACarnivore lion = new Lion();
        lion.setCurrentState(lion.getNormalState());
        
        AHerbivore antelope = new Antelope();
        
        factory.chInteraction(lion, antelope);
    }
    
    @Test
    public void testHpInteraction_eatBehavior(){
        System.out.println("**eat");
        
        InteractionFactory factory = new InteractionFactory();
        
        AHerbivore rabbit = new Rabbit();
        rabbit.setCurrentState(rabbit.getHungryState());
        
        APlant willow = new Willow();
        
        factory.hpInteraction(rabbit, willow);
    }
    
    @Test
    public void testHpInteraction_nothingTakePlaceBehavior() {
        System.out.println("**nothing");
        
        InteractionFactory factory = new InteractionFactory();
        
        AHerbivore rabbit = new Rabbit();
        
        APlant willow = new Willow();
        
        factory.hpInteraction(rabbit, willow);
    }
    
}
