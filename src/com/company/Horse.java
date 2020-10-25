package com.company;

public class Horse extends Animal {

    public Horse(String name, Gender gender) {

        super(name,gender,30,2);
    }

    @Override
    public void feedAnimal(Food food){
        if (food.getClass().equals(Bread.class) || (food.getClass().equals(Pellets.class))) {
            super.feedAnimal(food);
        } else {
            System.out.println("Horses can't eat meat!");
        }
    }

    @Override
    public Animal mate(){
        Gender gender = Math.random() < 0.5 ? Gender.MALE : Gender.FEMALE;
        String horseName = "";
        Horse horse = new Horse(horseName,gender);
        return horse;
    }
}
