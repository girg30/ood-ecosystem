package com.annvcit.model;

import com.annvcit.controller.ICreatureFactory;

/**
 * Hệ sinh thái. Gồm:
 *  +Loài ăn thịt
 *  +Loài ăn cỏ
 *  +Thực vật
 */
public class Ecosystem {
    private AHerbivore herbivore;
    private APlant plant;
    private ACarnivore carnivore;

    public Ecosystem(ICreatureFactory fact) {
//        carnivore = fact.createCarnivore();
//        herbivore = fact.createHerbivore();
//        plant = fact.createPlant();
    }

    public AHerbivore getHerbivore() {
        return herbivore;
    }

    public void setHerbivore(AHerbivore herbivore) {
        this.herbivore = herbivore;
    }

    public APlant getPlant() {
        return plant;
    }

    public void setPlant(APlant plant) {
        this.plant = plant;
    }

    public ACarnivore getCarnivore() {
        return carnivore;
    }

    public void setCarnivore(ACarnivore carnivore) {
        this.carnivore = carnivore;
    }
    
}
