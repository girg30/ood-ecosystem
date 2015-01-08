package com.annvcit.model;

import java.util.Random;

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
        Random random = new Random();
        AAnimal result = null;
        int number = random.nextInt(10);
        if (number >5) {
            a2.setCurrentState(a2.getNormalState());
            result = a1;
        }
        else {
            a1.setCurrentState(a1.getNormalState());
            result = a2;
        }
        return result;
    }
}
