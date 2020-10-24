package com.company;
import java.lang.Math;

public class Bear extends Animal {

    public Bear(String name, Gender gender) {
        super(name,gender,10,1);
    }

    @Override
    public void feedAnimal(Food food){
        super.feedAnimal(food);
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String bearName = "";
        Bear bear = new Bear(bearName,gender);
        return bear;
        }
    }

