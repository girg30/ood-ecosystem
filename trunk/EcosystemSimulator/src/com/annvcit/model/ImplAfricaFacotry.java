package com.annvcit.model;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần
 * cụ thể cần cho 1 hệ sinh thái cụ thể. Ở đây là Africa
 */
public class ImplAfricaFacotry implements ICreatureFactory {
    
    @Override
    public ACarnivore createCarnivore() {
        return new Lion();
    }

    @Override
    public AHerbivore createHerbivore() {
        return new Antelope();
    }

    @Override
    public APlant createPlant() {
        return new Grass();
    }
}
