package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Класс кошельки
public class Wallet extends Money {

    static String file = "wallet.txt";
    static ArrayList<Money> wallet = new ArrayList<>();

    public Wallet(String name, String sum) {
        super(name, sum);
    }

    public static void loader() throws IOException {
        Menu.filesAll(wallet, file);
    }

    static void operatorWallet() throws IOException {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("Работа с кошельком: ");
            System.out.println("1. Добавления кошелька");
            System.out.println("2. Удоление кошелька");
            System.out.println("3. Редактирование кошелька");
            System.out.println("4. Состояния кошелька");
            System.out.println("5. Сохранение");
            System.out.println("6. Выход");
            System.out.print("-> ");

            choice = in.nextInt();
            switch (choice) {

                case 1 -> Menu.addWallet(wallet);
                case 2 -> Menu.delete(wallet);
                case 3 -> Menu.update(wallet);
                case 4 -> Menu.findAll(wallet);
                case 5 -> Menu.saveWallet(wallet, file);
                case 6 -> System.out.println("Bye");          // выход
                default -> System.out.println("Invalid action");
            }

        }
    }
}




