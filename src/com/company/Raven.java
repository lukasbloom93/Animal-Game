package com.company;

public class Raven extends Animal {

    public Raven(String name, Gender gender) {
        super(name,gender,40,2);
    }

    @Override
    public void feedAnimal(Food food){
        super.feedAnimal(food);
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String ravenName = "";
        Raven raven = new Raven(ravenName,gender);
        return raven;
    }
}
