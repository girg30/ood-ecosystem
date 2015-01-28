package com.annvcit.controller;

import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;

import java.awt.Graphics;

/**
 * Lớp trừu tượng. Định nghĩa các phương thức tạo các
 * sinh vật thành phần cho hệ sinh thái.
 */
public interface ICreatureFactory {
    public ACarnivore createCarnivore();

    public AHerbivore createHerbivore();

    public APlant createPlant();

    public void drawAnimals(Graphics g);
    
    public void askLionMove();
    
}
