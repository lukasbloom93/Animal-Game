package com.company;

public class Tiger extends Animal {
    private int storePrice = 20;
    private int reproduction = 2;

    public Tiger(String name, Gender gender) {
        super(name,gender);
    }

    public void feed(){
        super.feedAnimal();
    }
}