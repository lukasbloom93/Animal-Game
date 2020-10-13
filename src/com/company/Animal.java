package com.company;

public abstract class Animal{
    String name;
    int hitPoints = 100;

    enum Gender {
        MALE, FEMALE
    }
    Gender gender;

    public void feedAnimal(){}

public void decreaseHP(){}

}
