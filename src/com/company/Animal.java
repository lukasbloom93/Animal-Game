package com.company;
import java.lang.Math;
import java.util.Scanner;

public abstract class Animal{
    String name = "";
    int hitPoints = 100;
    int storePrice;
    int reproduction;

    enum Gender {
        MALE, FEMALE
    }

    Gender gender;

    public Animal(String name, Gender gender, int storePrice,int reproduction){
        this.name = name;
        this.gender = gender;
        this.storePrice = storePrice;
        this.reproduction = reproduction;
    }

   public static void feedAnimalMenu(Player player) {

       Scanner scan = new Scanner(System.in);
       String animalToFeed = "";
       int foodToFeed;

       do {
           System.out.println("Which animal would you like to feed?"
                   + "\n Type the animals name and press Enter."
                   + "\n When you are done feeding your animals type 0 and press Enter to end your turn.");

               animalToFeed = scan.next();

               System.out.println("Which food would you like give your animal?"
                       + "\n 1. Bread"
                       + "\n 2. Pellets"
                       + "\n 3. Meat");

               foodToFeed = scan.nextInt();



               for (int i = 0; i < player.playerAnimals.size(); i++) {
                   if (player.playerAnimals.get(i).name.equals(animalToFeed)) {
                       //player.playerAnimals.get(i).feedAnimal();
                       break;
                   }
               }
       } while (!animalToFeed.equals("0"));
   }

     public void feedAnimal(Food food){
        hitPoints += 10;
        if(hitPoints > 100){
            hitPoints = 100;
            }
        }

    public abstract Animal mate();

    public void mateAnimalMenu(Player player){
        Scanner scan = new Scanner(System.in);
        String animal1 = "";
        String animal2 = "";

        System.out.println("Which two animals would you like to mate?"
            + "\n Type the name of your first animal and press Enter.");

        animal1 = scan.next();

        for (int i = 0; i < player.playerAnimals.size(); i++) {
            if (player.playerAnimals.get(i).name.equals(animal1)) { }
        }

        System.out.println("Type the name of your second animal and press Enter.");

        animal2 = scan.next();

                for (int i = 0; i < player.playerAnimals.size(); i++) {
                    if (player.playerAnimals.get(i).name.equals(animal2)) {
                    }
                }

    }

        //if 50% chance happens (Math.random over 0.5), then reproduction happens
        // an amount equal to reproduction value in animal class will create new animals with
        // random gender of the same class
        // they will be named and added to playerAnimals.



    public void decreaseHP(){
        int max = 30;
        int min = 10;
        int range = max - min + 1;

        int randomNumber = (int)(Math.random() * range) + min;
        this.hitPoints -= randomNumber;
    }

    @Override
    public String toString() {
        return name + " " + hitPoints + "/100 Health";
    }
}
