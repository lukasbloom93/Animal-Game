package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game(){

    boolean gameOn = true;
    final Scanner scan = new Scanner(System.in);
    int playerCount;
    int roundCounter = 0;
    int round;
    ArrayList<String> players;

    String temp = players.get(0);

    public void setupGame(){
        System.out.println("Welcome to Animal Farm!"
                +"\n How many players will be playing? (Type a number, 1-4 and press enter to select)");

        scan.nextInt() = playerCount;

        for(var i = 1; i <= playerCount; i++) {
            System.out.println("Enter player " + i + "'s name: ");
            players.add((scan.next()));
        }

        System.out.println("Please choose the number of rounds you would like to play."
                + "\n Enter a number between 5 and 30");

        scan.nextInt() = round;
        int totalRounds = playerCount*round;
    }

       while (gameOn){

        public void turnAction(){
        System.out.println("It is now " + "'s turn!"
                + "\n What would you like to do? You may only perform one action per turn."
                + "\n Type an integer and press enter to continue."
                + "\n"
                + "\n 1. Buy Animals"
                + "\n 2. Buy Food"
                + "\n 3. Feed Animals"
                + "\n 4. Mate Animals"
                + "\n 5. Sell Animals"
                + "\n 6. Check Inventory (Does not count as an action)");

        scan.nextInt() = int action;

        int choice = switch (action) {
            case 1 -> buyAnimal();
            case 2 -> buyFood();
            case 3 -> feedAnimal();
            case 4 -> mateAnimal();
            case 5 -> sellAnimal();
            case 6 -> checkInventory();
            default -> retry turnAction
        }

        public void rounds () {
            if (roundCounter >= totalRounds) {
                System.out.println("The game is over!");

                /* I need to find the player with the most gold, use sort */
                gameOn = false;
            }
        }
    }
       }
}
}

    public void players(){}

    public void checkInventory(){
        System.out.println(this.players.gold+" "+this.players.playersAnimals+" "+this.players.playerFood);
    }

   public void buyAnimal(){}

    public void sellAnimal(){}

    public void feedAnimal(){}

    public void buyFood(){}

    public void mateAnimal(){}
