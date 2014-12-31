package com.annvcit.model;

import org.junit.Test;

public class InteractionFactoryTest {

    @Test
    public void testCchhInteraction_fightBehavior() {
        // test trường hợp đúng: chỉ có carnivore vs carnivore hoặc
        // herbivore vs herbivore, không có trường hợp khác
        ACarnivore c1 = new Lion();
        ACarnivore c2 = new Lion();
        
        InteractionFactory factory = new InteractionFactory();
        factory.cchhInteraction(c1, c2);
        
        AHerbivore a1 = new Antelope();
        AHerbivore a2 = new Antelope();
        factory.cchhInteraction(a1, a2);
    }
    
    @Test
    public void testCchhInteraction_breedBehavior() {
        // TODO not yet
    }
    
    @Test
    public void testCchhInteraction_nothingTakePlaceBehavior() {
        // TODO not yet
    }
}
