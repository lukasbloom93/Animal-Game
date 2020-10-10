package com.company;

public abstract class Animal {
    String name;
    int hitPoints;

    enum Gender {
        MALE, FEMALE
    }
    Gender gender;

    abstract void feedAnimal();



}
