package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PotentialCosts extends Money {
    static ArrayList<Money> potentialCosts = new ArrayList<>(); //Потенциальные затраты
    static Scanner sc = new Scanner(System.in);
    static int choice = 0;
    static String file;

    public PotentialCosts(String name, int sum) {
        super(name, sum);
        this.file = "PotentialCosts.txt";
    }


    public static void operatorPotentialCosts() throws IOException {
        while (choice != 6) {

            Menu money = new Menu();
            File files = new File(file);
            if (!files.exists()) {
                files.createNewFile();
            } else {
                money.readWallets(potentialCosts);
            }

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
                case 5 -> Menu.saveWallet(potentialCosts);    // Сохранить
                case 6 -> System.out.println("Bye");          // выход
                default -> System.out.println("Invalid action");
            }
        }
    }

}

