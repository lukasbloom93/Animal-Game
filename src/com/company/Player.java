package com.company;
import java.util.ArrayList;

public class Player {
    String name;
    int gold = 200;
    ArrayList<Animal> playerAnimals = new ArrayList<>();
    Bread playerBread = new Bread();
    Pellets playerPellets = new Pellets();
    Meat playerMeat = new Meat();


    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "Gold = " + gold +
                "   Animals = " + playerAnimals +
                "   Bread = " + playerBread.amount + " Kg" +
                "   Pellets = " + playerPellets.amount + " Kg" +
                "   Meat = " + playerMeat.amount + " Kg";
    }
}

