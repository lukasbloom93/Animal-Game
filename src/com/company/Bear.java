package com.company;


public class Bear extends Animal {
    private int storePrice = 10;
    private int reproduction = 1;

    public Bear(String name, Gender gender) {
        super(name,gender);
    }

    public void feed(){
        super.feedAnimal();
    }
}
