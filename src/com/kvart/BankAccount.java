package com.kvart;

public class BankAccount {
    private String name;
    private double count;
    public static double earningsBank = 0.0;

    public BankAccount(String name, double count) {
        this.name = name;
        this.count = count;
    }

    public void add(double money) {
        this.count = 0.995 * money;
        earningsBank += 0.005 * money;
    }

    public void transfer(BankAccount otherPerson, double money){
        this.count -= money;
        otherPerson.add(money * 0.995);
        earningsBank += 0.005 * money;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
