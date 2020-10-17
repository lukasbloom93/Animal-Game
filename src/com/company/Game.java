package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    boolean gameOn = true;
    boolean isValid = false;
    final Scanner scan = new Scanner(System.in);
    int playerCount;
    int roundCounter = 0;
    int round = 0;
    ArrayList<Player> allPlayers;
    int totalRounds;
    int activePlayer = 0;

    public Game() {
        setupGame();
        runGame();
    }
    public void setupGame() {
            do {
                System.out.println("Welcome to Animal Farm!"
                + "\n How many players will be playing? (Type a number, 1-4 and press enter to select)");

                playerCount = scan.nextInt();
                if (playerCount > 4 || playerCount < 1){
                    System.out.println("Try again!");
                }
                else{
                    isValid = true;
                }
            } while (!isValid);

            for (var i = 1; i <= playerCount; i++) {
                System.out.println("Enter player " + i + "'s name: ");
                String playerName = scan.next();
                Player player = new Player(playerName);
                allPlayers.add(player);
            }

            isValid = false;
            do {
                System.out.println("Please choose the number of rounds you would like to play."
                        + "\n Enter a number between 5 and 30");
                try {
                    round = scan.nextInt();
                }catch (Exception e){
                    round = 0;
                }
                if (round > 30 || round < 5){
                    System.out.println("Try again!");
                }
                else{
                    isValid = true;
                }

            } while (!isValid);

            totalRounds = playerCount * round;
    }

    public void checkInventory(){
        System.out.println(this.allPlayers.get(activePlayer).toString());
    }

    public void runGame(){
        while(gameOn) {
            turnAction();
            rounds();
        }
    }

        public void turnAction() {
            System.out.println("It is now " + allPlayers.get(activePlayer).name + "'s turn!");


            Player player = allPlayers.get(activePlayer);
            player.playerAnimals.forEach((animal) -> {
                if (animal.hitPoints <= 0) {
                    player.playerAnimals.remove(animal);
                    System.out.println(animal.name + "starved to death!");
                }
            });

            int action;
            isValid = false;

            checkInventory();

            do {
                System.out.println("\n What would you like to do? You may only perform one action per turn."
                        + "\n If your gold at any point reaches 0 you have lost the game!"
                        + "\n Type an integer and press enter to continue."
                        + "\n"
                        + "\n 1. Buy Animals"
                        + "\n 2. Buy Food"
                        + "\n 3. Feed Animals"
                        + "\n 4. Mate Animals"
                        + "\n 5. Sell Animals"
                        + "\n 6. Check Inventory (Does not count as an action)");

                action = scan.nextInt();
                if (action > 5 || action < 1) {
                    System.out.println("Try again!");
                } else {
                    isValid = true;
                }
            } while (!isValid);


            switch (action) {
                case 1 -> Store.buyAnimalMenu(player);
                case 2 -> Store.buyFoodMenu(player);
                case 3 -> Animal.feedAnimalMenu(player);
                case 4 -> Animal.mateAnimalMenu(player);
                case 5 -> Store.sellAnimalMenu(player);
            }

            player.playerAnimals.forEach(Animal::decreaseHP);

            if (player.gold <= 0) {
                System.out.println(player.name + "is out of the game!");
            }
            roundCounter++;
            activePlayer = (activePlayer + 1)% playerCount;
        }
        public void rounds(){
            if (roundCounter >= totalRounds) {
                System.out.println("The game is over!");

                allPlayers.sort((Player a, Player b) -> { return a.gold > b.gold ? -1 : 1; });
                System.out.println(allPlayers.get(0) + "has won the game!");

                gameOn = false;
            }
        }
    }




