package com.company;
import java.lang.Math;
import java.util.Scanner;

public abstract class Animal{
    static Scanner scan = new Scanner(System.in);
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

       do {
           System.out.println("Which animal would you like to feed?"
                   + "\n Type the animals name and press Enter."
                   + "\n When you are done feeding your animals type 0 and press Enter to end your turn.");

           scan.reset();
           animalToFeed = scan.next();

               if(!animalToFeed.equals("0")) {
                   for (int i = 0; i < player.playerAnimals.size(); i++) {
                       if (player.playerAnimals.get(i).name.equals(animalToFeed)) {
                           selectFood(player,player.playerAnimals.get(i));
                           break;
                       }
                   }
               }

       } while (!animalToFeed.equals("0"));
   }
        private static void selectFood(Player player,Animal animal) {
            boolean validFood;
            int foodToFeed;

            do {
                validFood = false;
                foodToFeed = 0;

                System.out.println("Which food would you like give your animal?"
                        + "\n 1. Bread"
                        + "\n 2. Pellets"
                        + "\n 3. Meat"
                        + "\n 4. Previous menu.");

                try {
                    String foodToFeedString = "";
                    scan.reset();
                    foodToFeedString = scan.next();
                    foodToFeed = Integer.parseInt(foodToFeedString);
                }catch(Exception e){
                    System.out.println("Try again");
                }

                switch (foodToFeed) {
                    case 1 -> {
                        if (player.playerBread.amount > 0) {
                            animal.feedAnimal(player.playerBread);
                        }
                        else{ System.out.println("You don't have any bread!");}
                    }
                    case 2 -> {
                        if (player.playerPellets.amount > 0) {
                            animal.feedAnimal(player.playerPellets);
                        }
                        else{ System.out.println("You don't have any pellets!");}
                    }
                    case 3 -> {
                        if (player.playerMeat.amount > 0) {
                            animal.feedAnimal(player.playerMeat);
                        }
                        else{ System.out.println("You don't have any meat!");}
                    }
                    case 4 -> validFood = true;
                }
            }while(!validFood);
        }

     public void feedAnimal(Food food){
        food.amount --;
        hitPoints += 10;
        System.out.println("Your animal ate the food!");
        if(hitPoints > 100){
            hitPoints = 100;
            }
        }

    public abstract Animal mate();

    public static void mateAnimalMenu(Player player){
        Scanner scan = new Scanner(System.in);
        String animalName = "";
        Animal animal1;
        Animal animal2;

        do {
            animal1 = null;
            animal2 = null;

            System.out.println("Which two animals would you like to mate?"
                    + "\n Type the name of your first animal and press Enter."
                    + "\n When you are done, type 0 and press Enter to end your turn.");

            animalName = scan.next();

            for (int i = 0; i < player.playerAnimals.size(); i++) {
                if (player.playerAnimals.get(i).name.equals(animalName)) {
                    animal1 = player.playerAnimals.get(i);
                }
            }

            if(animal1 != null) {
                System.out.println("Type the name of your second animal and press Enter.");

                scan.reset();
                animalName = scan.next();

                for (int i = 0; i < player.playerAnimals.size(); i++) {
                    if (player.playerAnimals.get(i).name.equals(animalName)) {
                        animal2 = player.playerAnimals.get(i);
                    }
                }
                boolean matingSuccess = Math.random() < 0.5;

                if(animal2 != null
                        && matingSuccess
                        && checkMate(animal1,animal2)){
                    boolean validAnimalName = true;

                   Animal newborn = animal1.mate();

                   System.out.println("Congratulations! Your animals have mated successfully! \n"
                    + "\n What would you like to name the newborn?");

                   String newBornName = "";
                   do {
                       scan.reset();
                       newBornName = scan.next();
                       newborn.name = newBornName;

                       for (int i = 0; i < player.playerAnimals.size(); i++) {
                           if (player.playerAnimals.get(i).name.equals(newBornName) || newBornName.equals("0")) {
                               System.out.println("Try Again! \n");
                               validAnimalName = false;
                               break;
                           }
                       }
                   }while (!validAnimalName);

                    player.playerAnimals.add(newborn);
                    System.out.println(newBornName + " was added to animals! \n");

                    if(animal1.reproduction == 2) {
                        Animal newborn2 = animal1.mate();

                        System.out.println("There are two newborns! What would you like to name the second newborn?");
                        do {
                            scan.reset();
                            newBornName = scan.next();
                            newborn.name = newBornName;

                            for (int i = 0; i < player.playerAnimals.size(); i++) {
                                if (player.playerAnimals.get(i).name.equals(newBornName) || newBornName.equals("0")) {
                                    System.out.println("Try Again! \n");
                                    validAnimalName = false;
                                    break;
                                }
                            }
                        } while (!validAnimalName);
                        player.playerAnimals.add(newborn2);
                        System.out.println(newBornName + " was added to animals! \n");
                    }
                    animalName = "0";
                }
                else{
                    if(!matingSuccess){
                        System.out.println("The mating failed!");
                    }
                }
            }
        }while(!animalName.equals("0"));
    }
    public static boolean checkMate(Animal animal1,Animal animal2) {
        return animal1.getClass().equals(animal2.getClass())
                && animal1.gender != animal2.gender;
    }

    public void decreaseHP(){
        int max = 30;
        int min = 10;
        int range = max - min + 1;

        int randomNumber = (int)(Math.random() * range) + min;
        this.hitPoints -= randomNumber;
    }

    @Override
    public String toString() {
        return name + " " + hitPoints + "/100 Health " + gender;
    }
}
