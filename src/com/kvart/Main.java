package com.kvart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //Операции со временем

        TimeSpan timeSpan = new TimeSpan(1, 30);
        System.out.println("Заданое время: " + timeSpan);

        TimeSpan timeSpan1 = new TimeSpan(2, 15);
        timeSpan.add(timeSpan1);
        System.out.println("Время с прибавлением: " + timeSpan);

        timeSpan1.sub(timeSpan);
        System.out.println("Время с отниманием: " + timeSpan1);

        timeSpan.mult(2.5);
        System.out.println("Умноженое время: " + timeSpan);

        //======================================
        //Банковский аккаунт
        System.out.println();

        BankAccount boss = new BankAccount("Oleg", 0);
        BankAccount ivan = new BankAccount("Ivan", 0);
        BankAccount alex = new BankAccount("Alex", 0);
        BankAccount sergey = new BankAccount("Sergey", 0);

        boss.add(100000);
        System.out.println("Боссу поступило: " + boss);

        boss.transfer(ivan, 10000);
        boss.transfer(alex, 15000);
        boss.transfer(sergey, 20000);
        System.out.println("В итеге на счету после переводов:");
        System.out.println(boss);
        System.out.println(ivan);
        System.out.println(alex);
        System.out.println(sergey);
        System.out.println("Банк заработал: " + BankAccount.earningsBank);

        //=================================================
        //Задача с рюкзаками
        System.out.println();

        //Создаем обьекты и их список
        Items items = new Items(4, 12);
        Items items1 = new Items(3, 2);
        Items items2 = new Items(1, 1);
        Items items3 = new Items(2, 1);
        Items items4 = new Items(10, 4);
        Items items5 = new Items(15, 9);
        Items items6 = new Items(6, 8);
        Items items7 = new Items(14, 3);
        Items items8 = new Items(2, 7);

        List<Items> allItems = new ArrayList<>();
        allItems.add(items);
        allItems.add(items1);
        allItems.add(items2);
        allItems.add(items3);
        allItems.add(items4);
        allItems.add(items5);
        allItems.add(items6);
        allItems.add(items7);
        allItems.add(items8);

        //Создаем временные переменные
        List<Items> backpackTime = new ArrayList<>();
        List<Items> backpackEnd = new ArrayList<>();
        backpackEnd.add(items);
        List<Items> backpackEnd2 = new ArrayList<>();
        List<Items> allItemsTime = new ArrayList<>();
        int costTime = 0;
        int costEnd = 0;
        int weight = 0;

        //Наши рюкзаки
        List[] backpacks = new List[4];
        for (int i = 0; i < backpacks.length; i++) {
            backpacks[i] = new ArrayList<>();
        }

        //Сортировка
        allItemsTime.addAll(allItems);
        for (int m = 0; m < backpacks.length; m++) {
            //Ищем оптимальный вариант заполнения среди тех обьектов которые есть
            for (int i = 0; i < allItemsTime.size(); i++) {
                costTime += allItemsTime.get(i).getCost();
                weight += allItemsTime.get(i).getWeight();
                backpackTime.add(allItemsTime.get(i));
                for (int j = 0; j < allItemsTime.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    if (weight <= 15) {
                        costTime += allItemsTime.get(j).getCost();
                        weight += allItemsTime.get(j).getWeight();
                        backpackTime.add(allItemsTime.get(j));
                        if (weight > 15) {
                            costTime -= allItemsTime.get(j).getCost();
                            weight -= allItemsTime.get(j).getWeight();
                            backpackTime.remove(allItemsTime.get(j));

                        }
                    }
                }

                //Самый оптимальный вариант записываем в backpackEnd
                if (costTime >= costEnd) {
                    costEnd = costTime;
                    backpackEnd.removeAll(backpackEnd);
                    backpackEnd.addAll(backpackTime);
                }
                backpackTime.removeAll(backpackTime);
                costTime = 0;
                weight = 0;

            }

            //Сохраняем результат в рюкзак
            backpacks[m].addAll(backpackEnd);

            //Удаляем обьекты уже помещенные в рюкзаки
            backpackEnd2.addAll(allItemsTime);
            for (int j = 0; j < backpackEnd.size(); j++) {
                for (int k = backpackEnd2.size() - 1; k >= 0; k--) {
                    if (backpackEnd2.get(k).getCost() == backpackEnd.get(j).getCost() &&
                            backpackEnd2.get(k).getWeight() == backpackEnd.get(j).getWeight()) {
                        backpackEnd2.remove(k);
                    }
                }
            }

            //Передаем список оставшихся обьектов и обнуляем переменные
            costEnd = 0;
            backpackEnd.removeAll(backpackEnd);
            allItemsTime.removeAll(allItemsTime);
            allItemsTime.addAll(backpackEnd2);
            backpackEnd2.removeAll(backpackEnd2);

        }

        //Выводим рюкзаки
        for (int i = 0; i < backpacks.length; i++) {
            System.out.println("Рюкзак " + (i + 1) + ":");
            for (int j = 0; j < backpacks[i].size(); j++) {
                System.out.println(backpacks[i].get(j));
            }
        }

    }
}
