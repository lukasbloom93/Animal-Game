package com.company;

public class Wolf extends Animal {

    public Wolf(String name, Gender gender) {
        super(name,gender,50,2);
    }
@Override
    public void feedAnimal(Food food){
    if (food.getClass().equals(Meat.class)) {
        super.feedAnimal(food);
    } else {
        System.out.println("Wolfs can only eat meat!");
    }
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String wolfName = "";
        Wolf wolf = new Wolf(wolfName,gender);
        return wolf;
    }
}

