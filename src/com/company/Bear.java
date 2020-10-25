package com.company;
import java.lang.Math;

public class Bear extends Animal {

    public Bear(String name, Gender gender) {
        super(name,gender,10,1);
    }

    @Override
    public void feedAnimal(Food food) {
        if (food.getClass().equals(Meat.class)) {
            super.feedAnimal(food);
        } else {
            System.out.println("Bears can only eat meat!");
        }
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String bearName = "";
        return new Bear(bearName,gender);
        }
    }

