package com.company;

public class Wolf extends Animal {
    private int storePrice = 50;
    private int reproduction = 5;

    public Wolf(String name, Gender gender) {
        super(name,gender);
    }

    public void feed(){
        super.feedAnimal();
    }
}

