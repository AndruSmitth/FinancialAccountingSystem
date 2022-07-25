package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Потенциальные Затраты
public class PotentialCosts extends Money {
    static String file = "potentialCosts.txt";
    static ArrayList<Money> potentialCosts = new ArrayList<>(); //Потенциальные затраты
    static Scanner sc = new Scanner(System.in);
    static int choice = 0;


    public PotentialCosts(String name, String sum) {
        super(name, sum);
    }

    public static void loader() throws IOException {
        Menu.filesAll(potentialCosts, file);
    }

    public static void operatorPotentialCosts() throws IOException {
        while (choice != 6) {

            // простое меню
            System.out.println("Потенциальные Затраты: ");
            System.out.println("1 - Посмотреть");
            System.out.println("2 - Добавить");
            System.out.println("3 - Редактировать");
            System.out.println("4 - Удалить");
            System.out.println("5 - Сохранить");
            System.out.println("6 - Выход");

            System.out.print("Action: ");
            choice = sc.nextInt();  // получили ввод

            switch (choice) {
                case 1 -> Menu.findAll(potentialCosts);       // Посмотреть
                case 2 -> Menu.addWallet(potentialCosts);     // Добавить
                case 3 -> Menu.update(potentialCosts);        // Редактировать
                case 4 -> Menu.delete(potentialCosts);        // Удалить
                case 5 -> Menu.saveWallet(potentialCosts, file);    // Сохранить
                case 6 -> System.out.println("Bye");          // выход
                default -> System.out.println("Invalid action");
            }
        }
    }

}

