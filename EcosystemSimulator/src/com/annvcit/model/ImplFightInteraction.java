package com.annvcit.model;

/**
 * Tương tác chiến đấu. Xảy ra khi 2 đv gặp nhau trog tình trạng khang hiếm thức ăn
 * (chết đói)
 * */
public class ImplFightInteraction implements IInteraction {
    
    private AAnimal a1;
    private AAnimal a2;
    
    public ImplFightInteraction(AAnimal a1, AAnimal a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public Object interact() {

    	AAnimal willBeRemoved = null;
    	if(a1.getPower() + 100 > a2.getPower()) {
//    		a1.setCurrentState(a1.getNormalState());
//    		a1.setPower(1000);
    		willBeRemoved = a2;
//    		a2.setCurrentState(a2.getDeathState());
    	} else {
//    		a2.setCurrentState(a2.getNormalState());
//    		a2.setPower(1000);
    		willBeRemoved = a1;
//    		a1.setCurrentState(a1.getDeathState());
    	}
        return willBeRemoved;
    }
}
