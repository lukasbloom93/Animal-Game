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
    ArrayList<Player> allPlayers = new ArrayList<>();
    int totalRounds;
    int activePlayer = 0;

    public Game() {
        setupGame();
        runGame();
    }
    public void setupGame() {
            do {
                System.out.println("Welcome to Animal Farm!"
                        + "\n How many players will be playing? (Type a number, 1-4 and press Enter to select).");

                try {
                    String playerCountString = "";
                    playerCountString = scan.next();
                    playerCount = Integer.parseInt(playerCountString);
                    if (playerCount > 4 || playerCount < 1) {
                        System.out.println("Try again! \n");
                    } else {
                        isValid = true;
                    }
                }catch (Exception e) {
                    System.out.println("Try Again! \n");
                    scan.reset();
                }
            } while (!isValid) ;

            for (var i = 1; i <= playerCount; i++) {
                System.out.println("Enter Player " + i + "'s name:");
                String playerName = scan.next();
                Player player = new Player(playerName);
                allPlayers.add(player);
            }

            isValid = false;
            do {
                System.out.println("Please choose the number of rounds you would like to play."
                        + "\n Enter a number between 5 and 30.");
                try {
                    String roundString = "";
                    roundString = scan.next();
                    round = Integer.parseInt(roundString);
                }catch (Exception e){
                    scan.reset();
                    round = 0;
                }
                if (round > 30 || round < 5){
                    System.out.println("Try again!");
                    try {
                        String roundString = "";
                        roundString = scan.next();
                        round = Integer.parseInt(roundString);
                    }catch (Exception e){
                        scan.reset();
                        round = 0;
                    }
                    if (round <= 30 && round >= 5){
                        isValid = true;
                    }
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
            gameOver();
        }
    }

        public void turnAction() {
            ArrayList<Animal> playerAnimalsRemove = new ArrayList<>();

            System.out.println("It is now " + allPlayers.get(activePlayer).name + "'s turn! \n");

            Player player = allPlayers.get(activePlayer);
            player.playerAnimals.forEach((animal) -> {
                if (animal.hitPoints <= 0) {
                    playerAnimalsRemove.add(animal);
                    System.out.println(animal.name + " starved to death! \n");
                }
            });
            player.playerAnimals.removeAll(playerAnimalsRemove);

            int action = 0;
            isValid = false;

            checkInventory();

            do {
                System.out.println("\n What would you like to do?"
                        + "\n You may only perform one action per turn."
                        + "\n If your gold at any point reaches 0 you have lost the game!"
                        + "\n Type the number of your choice and press Enter to continue."
                        + "\n"
                        + "\n 1. Buy Animals"
                        + "\n 2. Buy Food"
                        + "\n 3. Feed Animals"
                        + "\n 4. Mate Animals"
                        + "\n 5. Sell Animals");

                try {
                    String actionString = "";
                    actionString = scan.next();
                    action = Integer.parseInt(actionString);
                }catch (Exception e){
                    scan.reset();
                }
                if (action > 5 || action < 1) {
                    System.out.println("Try again! \n");
                } else {
                    isValid = true;
                }
            } while (!isValid);

            switch (action) {
                case 1 -> Store.buyAnimalMenu(player);
                case 2 -> Store.buyFood(player);
                case 3 -> Animal.feedAnimalMenu(player);
                case 4 -> System.out.println("mate animal menu"); //Animal.mateAnimalMenu(player);
                case 5 -> {checkInventory(); Store.sellAnimalMenu(player);}
            }

            player.playerAnimals.forEach(Animal::decreaseHP);

            if (player.gold <= 0) {
                System.out.println(player.name + " is out of the game! \n");
                allPlayers.remove(player);
                if(allPlayers.isEmpty()){
                    System.out.println("Game Over!");
                    gameOn = false;
                }
            }
            roundCounter++;
            activePlayer = (activePlayer + 1)% playerCount;
        }

        public void gameOver(){
            if (roundCounter >= totalRounds) {
                System.out.println("The game is over! \n");

                allPlayers.forEach(player -> {
                    for (int i = 0; i < player.playerAnimals.size(); i++) {
                        Store.sellAnimal(player,player.playerAnimals.get(0));
                    }
                });

                allPlayers.sort((Player a, Player b) -> { return a.gold > b.gold ? -1 : 1; });
                Player winningPlayer = allPlayers.get(0);
                System.out.println(winningPlayer.name + " has won the game with " + winningPlayer.gold + "!");

                gameOn = false;
            }
        }
    }




