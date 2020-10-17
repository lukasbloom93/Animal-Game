package com.company;

public class Raven extends Animal {
    private int storePrice = 40;
    private int reproduction = 4;

    public Raven(String name, Gender gender) {
        super(name,gender);
    }

    public void feed(){
        super.feedAnimal();
    }
}
