package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Класс Карты
public class CreditCards extends Money {

    static String file = "credit.txt";
    static ArrayList<Money> credit = new ArrayList<>();


    public CreditCards(String name, String sum) {
        super(name, sum);
    }

    public static void loader() throws IOException {
        Menu.filesAll(credit, file);
    }

    static void operatorCredit() throws IOException {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("Работа с картами: ");
            System.out.println("1. Добавления карты");
            System.out.println("2. Удоление карты");
            System.out.println("3. Редактирование карты");
            System.out.println("4. Состояния карты");
            System.out.println("5. Сохранение");
            System.out.println("6. Выход");
            System.out.print("-> ");

            choice = in.nextInt();
            switch (choice) {

                case 1 -> Menu.addWallet(credit);           //Добавления карты
                case 2 -> Menu.delete(credit);              //Удоление карты
                case 3 -> Menu.update(credit);              //Редактирование карты
                case 4 -> Menu.findAll(credit);             //Состояния карты
                case 5 -> Menu.saveWallet(credit, file);    //Сохранение
                case 6 -> System.out.println("Bye");         // выход
                default -> System.out.println("Invalid action");

            }
        }
    }

}
