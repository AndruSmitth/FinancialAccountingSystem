package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Потенциальные доходы
public class Incomes extends Money {
    static String file = "incomes.txt";
    static ArrayList<Money> incomes = new ArrayList<>(); //Доходы
    static Scanner sc = new Scanner(System.in);
    static int choice = 0;


    public Incomes(String name, String sum) {
        super(name, sum);
    }

    public static void loader() throws IOException {
        Menu.filesAll(incomes, file);
    }

    public static void operatorIncomes() throws IOException {
        while (choice != 6) {

            // простое меню
            System.out.println("Потенциальные доходы: ");
            System.out.println("1 - Посмотреть");
            System.out.println("2 - Добавить");
            System.out.println("3 - Редактировать");
            System.out.println("4 - Удалить");
            System.out.println("5 - Сохранить");
            System.out.println("6 - Выход");

            System.out.print("Action: ");
            choice = sc.nextInt();  // получили ввод

            switch (choice) {
                case 1 -> Menu.findAll(incomes);       // Посмотреть
                case 2 -> Menu.addWallet(incomes);     // Добавить
                case 3 -> Menu.update(incomes);        // Редактировать
                case 4 -> Menu.delete(incomes);        // Удалить
                case 5 -> Menu.saveWallet(incomes, file);    // Сохранить
                case 6 -> System.out.println("Bye");          // выход
                default -> System.out.println("Invalid action");
            }
        }
    }
}

