package com.annvcit.model;

import java.util.Random;

import com.annvcit.util.ImageResource;

/**
 * Tương tác chiến đấu. Xảy ra khi 2 đv gặp nhau trog tình trạng khang hiếm thức ăn
 * (chết đói)
 * */
public class ImplFightInteraction implements IInteraction {
    
    private AAnimal a1;
    private AAnimal a2;
    private Random rd;
    
    public ImplFightInteraction(AAnimal a1, AAnimal a2) {
    	rd = new Random();
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public Object interact() {
    	int random = rd.nextInt(2);
    	
    	AAnimal victim = null;
    	
    	if(random == 1 ){
    		victim = a1;
    		a2.setPower(1000);
    		a2.setCurrentState(a2.getNormalState());
    	}else{
    		victim = a2;
    		a1.setPower(1000);
    		a1.setCurrentState(a1.getNormalState());
    	}
    	victim.setPower(AAnimal.DEAD_LINE);
    	victim.setCurrentState(victim.getDeathState());
    	if (victim instanceof Lion)
    		victim.setAvartar(victim.isMale() ? ImageResource.LION_MALE_DEAD : ImageResource.LION_FEMALE_DEAD);
    	else if (victim instanceof Antelope)
    		victim.setAvartar(victim.isMale() ? ImageResource.ANTELOPE_MALE_DEAD : ImageResource.ANTELOPE_FEMALE_DEAD);
        return victim;
    }
}
