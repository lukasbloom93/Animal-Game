package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    int gold = 100;
    ArrayList<Animal> playerAnimals;
    ArrayList<Food> playerFood;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                ", playerAnimals=" + playerAnimals +
                ", playerFood=" + playerFood +
                '}';
    }
}

