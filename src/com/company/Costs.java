package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Текущие затраты
public class Costs extends Money {
    static String file = "costs.txt";
    static ArrayList<Money> costs = new ArrayList<>(); //Расходы
    static Scanner sc = new Scanner(System.in);
    static int choice = 0;


    public Costs(String name, String sum) {
        super(name, sum);
    }

    public static void loader() throws IOException {
        Menu.filesAll(costs, file);
    }


    public static void operatorCosts() throws IOException {
        while (choice != 6) {
            // простое меню
            System.out.println("Текущие затраты: ");
            System.out.println("1 - Посмотреть");
            System.out.println("2 - Добавить");
            System.out.println("3 - Редактировать");
            System.out.println("4 - Удалить");
            System.out.println("5 - Сохранить");
            System.out.println("6 - Выход");
            System.out.print("Action: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> Menu.findAll(costs);       // Посмотреть
                case 2 -> Menu.addWallet(costs);     // Добавить
                case 3 -> Menu.update(costs);        // Редактировать
                case 4 -> Menu.delete(costs);        // Удалить
                case 5 -> Menu.saveWallet(costs, file);    // Сохранить
                case 6 -> System.out.println("Bye");          // выход
                default -> System.out.println("Invalid action");
            }
        }
    }

    @Override
    public String toString() {
        return "Costs{}";
    }
}

