package com.annvcit.model;

/**
 * Tương tác rượt đuổi. Xảy ra khi đv ăn thịt gặp đv ăn cỏ trong
 * trạng thái đói.
 * */
public class ImplChaseInteraction implements IInteraction {
    
    @SuppressWarnings("unused")
    private ACarnivore carnivore;
    private AHerbivore herbivore;
    
    public ImplChaseInteraction(ACarnivore c, AHerbivore h) {
        this.carnivore = c;
        this.herbivore = h;
    }

    @Override
    public Object interact() {
        return herbivore;
    }
}
