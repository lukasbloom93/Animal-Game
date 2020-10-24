package com.company;

public abstract class Food {
    String name = "";
    int storePrice;
    int amount = 0;

    @Override
    public String toString() {
        return name + amount + "Kg";
    }
}
