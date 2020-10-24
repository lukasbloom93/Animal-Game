package com.company;

public class Wolf extends Animal {

    public Wolf(String name, Gender gender) {
        super(name,gender,50,2);
    }
@Override
    public void feedAnimal(Food food){
        super.feedAnimal(food);
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String wolfName = "";
        Wolf wolf = new Wolf(wolfName,gender);
        return wolf;
    }
}

