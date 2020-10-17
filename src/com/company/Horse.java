package com.company;

public class Horse extends Animal {
    private int storePrice = 30;
    private int reproduction = 3;

    public Horse(String name, Gender gender) {
        super(name,gender);
    }

    public void feed(){
        super.feedAnimal();
    }
}
