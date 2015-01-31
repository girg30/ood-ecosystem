package com.annvcit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InteractionFactoryTest {

    @Test
    public void testCchhInteraction_fightBehavior() {
        System.out.println("**fight");
        InteractionFactory factory = new InteractionFactory();

        /* Carnivorous */
        AAnimal lion1 = new Lion();
        lion1.setCurrentState(lion1.getStarvedState());

        AAnimal lion2 = new Lion();
        lion2.setCurrentState(lion2.getStarvedState());

        /* Đây là random, hên xui :D */
        AAnimal actualLion = (AAnimal) factory.cchhInteraction(lion1, lion2)
                .interact();

        assertEquals(lion1, actualLion);
        
        // Kiểm tra xem sau khi fight thì trạng thái của con còn sống có normal hay không
        if(actualLion == lion2) {
            
            /*Vì sao kiểm tra lion1 trong phương thức này: vì con lion2
            sẽ bị chết nên chỉ kiểm tra trạng thái con còn sống có phải
            là normal hay không thôi*/
            
            IAnimalState lion1State = lion1.getCurrentState();
            assertTrue(lion1State instanceof ImplNormalState);
            assertFalse(lion1State instanceof ImplHungryState);
        }
        else {
            IAnimalState lion2State = lion2.getCurrentState();
            assertTrue(lion2State instanceof ImplNormalState);
            assertFalse(lion2State instanceof ImplStarvedState);
        }
        
        /* Herbivore */
        AAnimal antelope1 = new Antelope();
        antelope1.setCurrentState(antelope1.getStarvedState());

        AAnimal antelope2 = new Antelope();
        antelope2.setCurrentState(antelope2.getStarvedState());

        /* The same above */
        AAnimal actualAntelope = (AAnimal) factory.cchhInteraction(antelope1,
                antelope2).interact();
        assertEquals(antelope2, actualAntelope);
        
        // Sau khi fight thì kiểm tra trạn thái của con còn sống có phải là normal không
        if (actualAntelope == antelope1) {
            assertTrue(antelope2.getCurrentState() instanceof ImplNormalState);
            assertFalse(antelope2.getCurrentState() instanceof ImplStarvedState);
        } else {
            assertTrue(antelope1.getCurrentState() instanceof ImplNormalState);
            assertFalse(antelope2.getCurrentState() instanceof ImplStarvedState);
        }
    }

    @Test
    public void testCchhInteraction_breedBehavior() {
        System.out.println("**breed");
        InteractionFactory factory = new InteractionFactory();

        /* Carnivorous */
        AAnimal lion1 = new Lion();
        lion1.setSex('f');

        AAnimal lion2 = new Lion();
        lion2.setSex('m');

        /*Sẽ thấy trên colsole là 3 dòng Create new Lion phía dưới **breed*/
        factory.cchhInteraction(lion1, lion2).interact();

        // Khi breed thì trạng thái của 2 con đều bình thường
        assertTrue(lion1.getCurrentState() instanceof ImplNormalState);
        assertFalse(lion1.getCurrentState() instanceof ImplHungryState);
        
        assertTrue(lion2.getCurrentState() instanceof ImplNormalState);
        assertFalse(lion1.getCurrentState() instanceof ImplStarvedState);
        
        /* Herbivore */
        AAnimal rabbit1 = new Rabbit();
        rabbit1.setSex('m');

        AAnimal rabbit2 = new Rabbit();
        rabbit2.setSex('f');

        factory.cchhInteraction(rabbit1, rabbit2).interact();
        
        // kiểm tra trạng thái sau khi ấy nhau =]]
        assertTrue(rabbit1.getCurrentState() instanceof ImplNormalState);
        assertFalse(rabbit1.getCurrentState() instanceof ImplStarvedState);
        
        assertTrue(rabbit2.getCurrentState() instanceof ImplNormalState);
        assertFalse(rabbit2.getCurrentState() instanceof ImplHungryState);
    }

    @Test
    public void testCchhInteraction_nothingTakePlaceBehavior() {
        System.out.println("**nothing");
        InteractionFactory factory = new InteractionFactory();

        AAnimal wolf = new Wolf();
        AAnimal rabbit = new Rabbit();

        /*Có trả về 1 object không null*/
        Object o = factory.cchhInteraction(wolf, rabbit).interact();
        assertTrue(o != null);
        
        // hông có object nào để kiểm tra trạng thái
    }

    /*
     * What happend if carnivore has starved state and meet another animal has
     * mormal state, but they're opposite sex
     */
    @Test
    public void testCchhInteraction_extend1() {
        System.out.println("**extend 1");
        InteractionFactory factory = new InteractionFactory();
        
        AAnimal lion1 = new Lion();
        lion1.setCurrentState(lion1.getStarvedState());
        lion1.setSex('m');
        
        AAnimal lion2 = new Lion();
        lion2.setCurrentState(lion2.getStarvedState());
        lion2.setSex('f');
        
        // Sẽ thấy 3 dòng Create new Lion phía dưới **extend 1
        factory.cchhInteraction(lion1, lion2).interact();
        
        /*The answer is breeding... 
        The same for herbivorous*/
        
        // kiểm tra trạng thái 2 con sau khi breeding
        assertFalse(lion1.getCurrentState() instanceof ImplNormalState);
        assertTrue(lion1.getCurrentState() instanceof ImplStarvedState);
        /*Vì con lion1 đang starved nên sau khi "ấy nhau" nó vẫn starved,
        còn con lion2 normal nên sau khi ấy nó vẫn normal*/
        assertTrue(lion2.getCurrentState() instanceof ImplNormalState);
        assertFalse(lion2.getCurrentState() instanceof ImplStarvedState);
    }

    @Test
    public void testChInteraction_chaseBehavior() {
        System.out.println("**chase");

        InteractionFactory factory = new InteractionFactory();

        ACarnivore wolf = new Wolf();
        wolf.setCurrentState(wolf.getHungryState());

        AHerbivore rabbit = new Rabbit();

        Object actual = factory.chInteraction(wolf, rabbit).interact();
        // Kiểm tra xem có đúng là con rabbit bị die hay không 
        assertEquals(rabbit, actual);
        
        // Kiểm tra xem state của wolf sau khi ăn thỏ có đúng là normal hay không
        assertTrue(wolf.getCurrentState() instanceof ImplNormalState);
        assertFalse(wolf.getCurrentState() instanceof ImplHungryState);
    }

    @Test
    public void testChInteraction_nothingTakePlaceBehavior() {
        System.out.println("**nothing");

        InteractionFactory factory = new InteractionFactory();

        ACarnivore lion = new Lion();
        lion.setCurrentState(lion.getNormalState());

        AHerbivore antelope = new Antelope();

        Object o = factory.chInteraction(lion, antelope).interact();
        assertTrue(o != null);
    }

    @Test
    public void testHpInteraction_eatBehavior() {
        System.out.println("**eat");

        InteractionFactory factory = new InteractionFactory();

        AHerbivore rabbit = new Rabbit();
        rabbit.setCurrentState(rabbit.getHungryState());

        APlant willow = new Willow();

        Object actual = factory.hpInteraction(rabbit, willow).interact();
        assertEquals(willow, actual);
        
        // kiêm tra trạng thái của con rabbit sau khi ăn willow
        assertTrue(rabbit.getCurrentState() instanceof ImplNormalState);
        assertFalse(rabbit.getCurrentState() instanceof ImplHungryState);
    }

    @Test
    public void testHpInteraction_nothingTakePlaceBehavior() {
        System.out.println("**nothing");

        InteractionFactory factory = new InteractionFactory();

        AHerbivore rabbit = new Rabbit();

        APlant willow = new Willow();

        Object o = factory.hpInteraction(rabbit, willow).interact();
        assertTrue(o != null);
    }

}
