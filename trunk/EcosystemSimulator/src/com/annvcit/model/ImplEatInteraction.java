package com.annvcit.model;

/**
 * Tương tác ăn cỏ: đv ăn cỏ và thực vật (nếu đv ăn cỏ đói)
 * */
public class ImplEatInteraction implements IInteraction {
    
    private AHerbivore herbivore;
    private APlant plant;
    
    public ImplEatInteraction(AHerbivore h, APlant p) {
        this.herbivore = h;
        this.plant = p;
    }

    @Override
    public Object interact() {
        herbivore.setCurrentState(herbivore.getNormalState());
        return this.plant;
    }
    
}
