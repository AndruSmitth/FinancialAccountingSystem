package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreditCards extends Money {

    static String file;
    static ArrayList<Money> credit = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static boolean status = true;

    public CreditCards(String name, int sum) {
        super(name, sum);
        this.file = "credit.txt";
    }

    public static void operatorCredit() throws IOException {

        Menu money = new Menu();
        File files = new File(file);
        if (!files.exists()) {
            files.createNewFile();
        } else {
            money.readWallets(credit);
        }

        while (status) {
            System.out.println("1. Добавления кошелька");
            System.out.println("2. Удоление кошелька");
            System.out.println("3. Редактирование кошелька");
            System.out.println("4. Состояния кошелька");
            System.out.println("5. Сохранение");
            System.out.println("6. Выход");
            System.out.print("-> ");
            String selected = in.next();
            switch (selected) {

                case "1" -> Menu.addWallet(credit);
                case "2" -> Menu.delete(credit);
                case "3" -> Menu.update(credit);
                case "4" -> Menu.findAll(credit);
                case "5" -> Menu.saveWallet(credit);
                case "6" -> {
                    in.close();
                    status = false;
                    break;
                }
                default -> System.out.println("Выход");

            }
        }
    }

}
