package com.annvcit.model;

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
