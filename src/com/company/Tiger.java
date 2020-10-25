package com.company;

public class Tiger extends Animal {

    public Tiger(String name, Gender gender) {
        super(name,gender,20,1);
    }

    @Override
    public void feedAnimal(Food food){

        if (food.getClass().equals(Meat.class) || (food.getClass().equals(Pellets.class))) {
            super.feedAnimal(food);
        } else {
            System.out.println("Tigers can't eat bread!");
        }
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String tigerName = "";
        Tiger tiger = new Tiger(tigerName,gender);
        return tiger;
    }
}