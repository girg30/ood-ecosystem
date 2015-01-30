package com.annvcit.controller;

import java.awt.Graphics;

/**
 * Lớp trừu tượng. Định nghĩa các phương thức tạo các
 * sinh vật thành phần cho hệ sinh thái.
 */
public interface ICreatureFactory {
    public void createCarnivore();

    public void createHerbivore();

    public void createPlant();
    
    public void drawBackground(Graphics g);

    public void draw(Graphics g);
    
    public void askCarnivoreMove();
    
    public void askHerbivoreMove();
    
    void respawn();
    
}
