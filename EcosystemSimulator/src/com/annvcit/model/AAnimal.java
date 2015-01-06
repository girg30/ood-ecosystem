package com.annvcit.model;

/**
 * Lớp trừu tượng. Lớp cha của các loài động vật.
 * Ở đây định nghĩa các thuộc tính, hành vi chung của động vật.
 * */
public abstract class AAnimal {
    
    private IAnimalState normalState;
    private IAnimalState starvedState;
    private IAnimalState hungryState;
    private IAnimalState currentState;
    
    private char sex; // m (male) and f (female)
    
    public AAnimal() {
        normalState = new ImplNormalState();
        starvedState = new ImplStarvedState();
        hungryState = new ImplHungryState();
        currentState =  normalState;
    }

    /**
     * kiểm tra xem đv này có khác giới với động vật kia hay không
     * @param anotherAnimal đv khác
     * @return true nếu khác giới
     * */
    public boolean isOppositeSex(AAnimal anotherAnimal) {
        return this.sex != anotherAnimal.getSex();
    }
    
    public IAnimalState getNormalState() {
        return normalState;
    }

    public void setNormalState(IAnimalState normalState) {
        this.normalState = normalState;
    }

    public IAnimalState getStarvedState() {
        return starvedState;
    }

    public void setStarvedState(IAnimalState starvedState) {
        this.starvedState = starvedState;
    }

    public IAnimalState getHungryState() {
        return hungryState;
    }

    public void setHungryState(IAnimalState hungryState) {
        this.hungryState = hungryState;
    }

    public IAnimalState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IAnimalState currentState) {
        this.currentState = currentState;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
