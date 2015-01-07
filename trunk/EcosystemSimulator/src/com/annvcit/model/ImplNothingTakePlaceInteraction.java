package com.annvcit.model;

/**
 * Tương tác không tương tác :)
 * Có nghĩa là không có gì xảy ra.
 * */
public class ImplNothingTakePlaceInteraction implements IInteraction {
    
    public ImplNothingTakePlaceInteraction() {
        System.out.println("There's nothing take place...");
    }
    
    @Override
    public Object interact() {
        /*Tránh return null*/
        /*Dùng phương thức remove(Object o) để remove => chỉ return true or false, không throw Exception*/
        return new Object(); 
    }
}
