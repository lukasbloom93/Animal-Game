package com.company;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Animal{
    String name = "";
    int hitPoints = 100;

    enum Gender {
        MALE, FEMALE
    }
    Gender gender;

    public Animal(String name, Gender gender){
        this.name = name;
        this.gender = gender;

    }

    public void feedAnimal(){

    }

    public void decreaseHP(){
        int max = 30;
        int min = 1;
        int range = max - min + 1;

        int randomNumber = (int)(Math.random() * range) + min;
        this.hitPoints -= randomNumber;
        }

    public void mateAnimal(){

    }

}
