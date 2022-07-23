package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Wallet.file;

public class Menu {

    static Scanner in = new Scanner(System.in);
    private static String tname;
    private static int tsum;


    static void update(ArrayList<Money> list) throws IOException {
        System.out.println("Введите имя: ");
        String unam = in.next();
        System.out.println("Сумму: ");
        int unum = in.nextInt();
        for (Money money : list) {
            if (money.getName().equals(unam)) {
                money.setSum(Integer.parseInt(String.valueOf(unum)));
            }
        }

    }

    static void delete(ArrayList<Money> list) {
        System.out.println("Введите имя: ");
        String dname = in.next();
        for (int i = 0; i < list.size(); i++) {
            Money money = list.get(i);
            if (money.getName().equals(dname)) {
                list.remove(money);
            } else {
                continue;
            }
        }
    }

    static void findAll(ArrayList<Money> list) {
        for (Money money: list) {
            System.out.println(money.toString());
        }
    }

    static void addWallet(ArrayList<Money> list) {
        System.out.println("Введите имя:");
        tname = in.next();
        System.out.println("Введите сумму:");
        tsum = in.nextInt();
        Money money = new Wallet(tname, tsum);
        list.add(money);
        System.out.println(money.toString());
    }

    public void readWallets(ArrayList<Money> list) {
        FileInputStream filein;
        try {
            filein = new FileInputStream(file);
            if (filein.available() == 0) {
                System.out.println("Содержимое пустое");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(filein));
                String line = null;
                Money money = null;
                    list.add(money);
                filein.close(); // Закрыть поток ввода байтов
                br.close(); // Закрыть буфер депозита
                System.out.println("Список загружен, вы можете выполнять операции с данными ...");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveWallet(ArrayList<Money> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Money money : list) {
                bw.write(money.getName() + "," + money.getSum());
                bw.write("\r\n");
            }
            bw.flush(); // Очистить кеш
            System.out.println("Сохранено");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
