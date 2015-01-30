package com.annvcit.model;

/**
 * Tương tác không tương tác :)
 * Có nghĩa là không có gì xảy ra.
 * */
public class ImplNothingTakePlaceInteraction implements IInteraction {
	
    public ImplNothingTakePlaceInteraction(Object...objects) {
    	if (objects[0] instanceof ACarnivore && objects[1] instanceof ACarnivore) {
    		ACarnivore a1 = (ACarnivore) objects[0];
    		ACarnivore a2 = (ACarnivore) objects[1];
    		a1.setCurrentState(a1.getStarvedState());
    		a2.setCurrentState(a2.getStarvedState());
    	}
    }
 
    @Override
    public Object interact() {return new Lion(); } // để khi return về kiểm tra ko có tọa độ thì ko add vào list
}
