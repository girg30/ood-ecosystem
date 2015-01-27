package com.annvcit.controller;

import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;
import com.annvcit.model.Rabbit;
import com.annvcit.model.Willow;
import com.annvcit.model.Wolf;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần
 * cụ thể cần cho 1 hệ sinh thái cụ thể. Ở đây là Fiinish
 */
public class ImplFinnishFactory implements ICreatureFactory {
    @Override
    public ACarnivore createCarnivore() {
        return new Wolf();
    }

    @Override
    public AHerbivore createHerbivore() {
        return new Rabbit();
    }

    @Override
    public APlant createPlant() {
        return new Willow();
    }
}
