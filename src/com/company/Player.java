package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    int gold = 100;
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
                "   Bread = " + playerBread.amount +
                "   Pellets = " + playerPellets.amount +
                "   Meat = " + playerMeat.amount;
    }
}

