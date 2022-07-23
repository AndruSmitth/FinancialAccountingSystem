package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean status = true;


        while (status) {
            System.out.println("1. Работа с картой");
            System.out.println("2. Работа с кошельком");
            System.out.println("3. текущие затраты");
            System.out.println("4. потенциальные затраты");
            System.out.println("5. потенциальные доходы");
            System.out.println("6. Выход");
            System.out.print("-> ");
            String selected = in.next();
            switch (selected) {

                case "1" -> CreditCards.operatorCredit();
                case "2" -> Wallet.operatorWallet();
                case "3" -> Costs.operatorCosts();
                case "4" -> PotentialCosts.operatorPotentialCosts();
                case "5" -> Incomes.operatorIncomes();
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
