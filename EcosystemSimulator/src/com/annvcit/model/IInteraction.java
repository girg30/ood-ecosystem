package com.annvcit.model;

/**
 * Lớp trừu tượng. Định nghĩa các tương tác (interaction) khác nhau dựa vào các tình huống khác nhau
 * của động vật.
 */
public interface IInteraction {
    
    /**
     * Hàm này định nghĩa kết quả interact của 2 creatures
     * @param objects các đối tượng sẽ tương tác với nhau
     * @return đối tượng sẽ bị remove hoăc được thêm vào Ecosystem
     * */
    public Object interact();
}
