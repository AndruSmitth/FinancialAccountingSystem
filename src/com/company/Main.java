package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //загрузка колекций из файла.
        Costs.loader();
        PotentialCosts.loader();
        Incomes.loader();
        Wallet.loader();
        CreditCards.loader();

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("1. Работа с картой");
            System.out.println("2. Работа с кошельком");
            System.out.println("3. текущие затраты");
            System.out.println("4. потенциальные затраты");
            System.out.println("5. потенциальные доходы");
            System.out.println("6. Сумма кошельков и карт");
            System.out.println("7. Выход");
            System.out.print("-> ");

            choice = in.nextInt();
            switch (choice) {

                case 1 -> CreditCards.operatorCredit();                  //Работа с картой
                case 2 -> Wallet.operatorWallet();                       // Работа с кошельком
                case 3 -> Costs.operatorCosts();                         //текущие затраты
                case 4 -> PotentialCosts.operatorPotentialCosts();       //потенциальные затраты
                case 5 -> Incomes.operatorIncomes();                     //потенциальные доходы
                case 6 -> Menu.sumAll();                                 //Сумма кошельков и карт
                case 7 -> System.out.println("Bye");                     // выход
                default -> System.out.println("Invalid action");
            }


        }
    }

}

