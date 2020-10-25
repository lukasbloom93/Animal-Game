package com.company;
import java.util.Scanner;

public class Store {

    public static void buyAnimalMenu(Player player) {
        int action = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("What animal would you like to buy?"
                    + "\n 1. Bear   10g"
                    + "\n 2. Tiger  20g"
                    + "\n 3. Horse  30g"
                    + "\n 4. Raven  40g"
                    + "\n 5. Wolf   50g"
                    + "\n 6. End Turn");

            try {
                String actionString = "";
                scan.reset();
                actionString = scan.next();
                action = Integer.parseInt(actionString);
            }catch(Exception e){
                System.out.println("Try again");
            }
            if (action > 0 && action < 6) {
                switch (action){
                    case 1 -> {if(player.gold < 10) System.out.println("You can't afford that!");
                    else{ buyAnimal(player, action);}
                    }
                    case 2 -> {if (player.gold < 20) System.out.println("You can't afford that!");
                    else{ buyAnimal(player, action);}
                    }
                    case 3 -> {if (player.gold < 30) System.out.println("You can't afford that!");
                    else{ buyAnimal(player, action);}
                    }
                    case 4 -> {if (player.gold < 40) System.out.println("You can't afford that!");
                    else{ buyAnimal(player, action);}
                    }
                    case 5 -> {if (player.gold < 50) System.out.println("You can't afford that!");
                        else{ buyAnimal(player, action);}
                    }
                }
            }
        }while(action != 6);
    }

    public static void buyAnimal(Player player,int action){
        Scanner scan = new Scanner(System.in);
        String newAnimalName = "";
        int animalGenderChoice;
        Animal.Gender gender = Animal.Gender.MALE;
        boolean validGender;

        do{
            validGender = false;

            System.out.println("What gender should the animal be?"
                    + "\n type 1 for Male or 2 for Female.");

            try {
                String animalGenderChoiceString = "";
                animalGenderChoiceString = scan.next();
                animalGenderChoice = Integer.parseInt(animalGenderChoiceString);
            }catch (Exception e){
                System.out.println("Try Again!");
                animalGenderChoice = 0;
            }
            if (animalGenderChoice == 1) {
                validGender = true;
            }
            if (animalGenderChoice == 2) {
                gender = Animal.Gender.FEMALE;
                validGender = true;
            }
        }while(!validGender);

        boolean validAnimalName;
        do {
            validAnimalName = true;

            System.out.println("What would you like to name your animal?");

            scan.reset();
            newAnimalName = scan.next();

            for (int i = 0; i < player.playerAnimals.size(); i++) {
                if (player.playerAnimals.get(i).name.equals(newAnimalName) || newAnimalName.equals("0")){
                    System.out.println("Try Again! \n");
                    validAnimalName = false;
                    break;
                }
            }
        }while(!validAnimalName);

        switch (action) {
            case 1 -> { player.playerAnimals.add(new Bear(newAnimalName,gender));
                player.gold -= 10;}
            case 2 -> { player.playerAnimals.add(new Tiger(newAnimalName,gender));
                player.gold -= 20;}
            case 3 -> { player.playerAnimals.add(new Horse(newAnimalName,gender));
                player.gold -= 30;}
            case 4 -> { player.playerAnimals.add(new Raven(newAnimalName,gender));
                player.gold -= 40;}
            case 5 -> { player.playerAnimals.add(new Wolf(newAnimalName,gender));
                player.gold -= 50;}
        }
        System.out.println("Thank You! \n");
    }


    public static void sellAnimalMenu(Player player) {
        Scanner scan = new Scanner(System.in);
        String sellAnimalName = "";
        Animal animalToSell;

        do {
            System.out.println("What animal would you like to sell?"
                    + "\n Type the name of the animal and press Enter to sell."
                    + "\n If you want to exit, type 0 and press Enter to end your turn.");
            try {
                scan.reset();
                sellAnimalName = scan.next();

                for (int i = 0; i < player.playerAnimals.size(); i++) {
                    if (player.playerAnimals.get(i).name.equals(sellAnimalName)) {
                        animalToSell = player.playerAnimals.get(i);
                        sellAnimal(player, animalToSell);
                        break;
                    }
                }
            }catch(Exception e){
                System.out.println("Try Again! \n");
            }
        } while (!sellAnimalName.equals("0"));
    }

    public static void sellAnimal (Player player, Animal animal){
        player.gold += ((animal.hitPoints / 100.f) * animal.storePrice);
        System.out.println(player.name + " sold a " + animal.getClass().getSimpleName() + "! \n");
        player.playerAnimals.remove(animal);
        }

    public static void buyFood(Player player) {
        int action;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("What food would you like to buy?"
                    + "\n 1. Bread      5g"
                    + "\n 2. Pellets   10g"
                    + "\n 3. Meat      15g"
                    + "\n 4. End Turn");

            try {
                String actionString = "";
                scan.reset();
                actionString = scan.next();
                action = Integer.parseInt(actionString);
            }catch(Exception e) {
                System.out.println("Try again");
                action = 0;

            }
            if(action > 0 && action < 4) {
                switch (action) {
                    case 1 -> {
                        if(player.gold >= 5) {
                            player.playerBread.amount++;
                            player.gold -= 5;
                            System.out.println("Bread was added to your inventory! \n");
                        }
                        else{System.out.println("You can't afford that!");}
                    }
                    case 2 -> {
                        if(player.gold >= 10) {
                            player.playerPellets.amount++;
                            player.gold -= 10;
                            System.out.println("Pellets was added to your inventory! \n");
                        }
                        else{System.out.println("You can't afford that!");}
                    }
                    case 3 -> {
                        if(player.gold >= 15) {
                            player.playerMeat.amount++;
                            player.gold -= 15;
                            System.out.println("Meat was added to your inventory! \n");
                        }
                        else{ System.out.println("You can't afford that!");}
                    }
                }
            }
        }while(action != 4);
    }
}
