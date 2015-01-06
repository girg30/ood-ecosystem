package com.annvcit.model;

/**
 * Lớp trừu tượng. Định nghĩa các phương thức tạo các
 * sinh vật thành phần cho hệ sinh thái.
 */
public interface ICreatureFactory {
    public ACarnivore createCarnivore();

    public AHerbivore createHerbivore();

    public APlant createPlant();

}
