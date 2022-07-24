package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wallet extends Money {

    static String file = "wallet.txt";
    static ArrayList<Money> wallet = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static boolean status = true;


    public Wallet(String name, String sum) {
        super(name, sum);
    }



    public static void operatorWallet() throws IOException {

        Menu money = new Menu();
        File files = new File(file);
        if (!files.exists()) {
            files.createNewFile();
        } else {
            money.readWallets(wallet ,file);
        }


        while (status) {
            System.out.println("Работа с кошельком: ");
            System.out.println("1. Добавления кошелька");
            System.out.println("2. Удоление кошелька");
            System.out.println("3. Редактирование кошелька");
            System.out.println("4. Состояния кошелька");
            System.out.println("5. Сохранение");
            System.out.println("6. Выход");
            System.out.print("-> ");
            String selected = in.next();
            switch (selected) {

                case "1" -> Menu.addWallet(wallet);
                case "2" -> Menu.delete(wallet);
                case "3" -> Menu.update(wallet);
                case "4" -> Menu.findAll(wallet);
                case "5" -> Menu.saveWallet(wallet, file);
                case "6" -> {
                //    in.close();
                    status = false;
                    break;
                }
                default -> System.out.println("Выход");

            }
        }
    }


}


