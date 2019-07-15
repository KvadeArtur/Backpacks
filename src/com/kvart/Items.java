package com.kvart;

import java.util.Objects;

public class Items {
    private int cost;
    private int weight;

    public Items(int cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Items{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
