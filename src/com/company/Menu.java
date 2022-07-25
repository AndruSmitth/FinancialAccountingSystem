package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.CreditCards.credit;
import static com.company.Wallet.wallet;


public class Menu {

    static Scanner in = new Scanner(System.in);
    static String tname;
    static String tsum;

    // проверка на наличие файла
    // если файла нет он создаеться
    static void filesAll(ArrayList<Money> list, String file) throws IOException {
        File files = new File(file);
        if (!files.exists()) {
            files.createNewFile();
        } else {
            readWallets(list, file);
        }
    }

    // редактирование
    static void update(ArrayList<Money> list) throws IOException {
        System.out.println("Введите имя: ");
        String unam = in.next();
        System.out.println("Сумму: ");
        String unum = in.next();
        for (Money money : list) {
            if (money.getName().equals(unam)) {
                money.setSum(unum);
            }
        }
    }

    //удаление
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

    // чтение списка коллекций
    static void findAll(ArrayList<Money> list) {
        for (Money money: list) {
            System.out.println(money);
        }
        int sum = 0;
        for (Money money: list) {
            sum += Integer.parseInt(String.valueOf(money.getSum()));
        }
        System.out.println("Общая сумма = " + sum + "\n");
    }

    //добавление
    static void addWallet(ArrayList<Money> list) {
        System.out.println("Введите имя:");
        tname = in.next();
        System.out.println("Введите сумму:");
        tsum = in.next();
        Money money = new Wallet(tname, tsum);
        list.add(money);
        System.out.println(money.toString());
    }

    //чтение файла в коллекцию
    public static void readWallets(ArrayList<Money> list, String file) {
        FileInputStream filein;
        try {
            filein = new FileInputStream(file);
            if (filein.available() == 0) {
                System.out.println("Содержимое пустое");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(filein));
                String line = null;
                Money money = null;
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(",");
                    money = new Money(str[0], str[1]);
                    list.add(money);
                 }
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

    //сохранение и запись списка в файл
    public static void saveWallet(ArrayList<Money> list, String file) {
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

    //суммирование всех кошельков и карт.
    public static void sumAll() throws IOException {

        int sumWalet = 0;
        int sumCard = 0;
        for (Money money:wallet) {
            sumWalet += Integer.parseInt(String.valueOf(money.getSum()));
        }

        for (Money card:credit) {
            sumCard += Integer.parseInt(String.valueOf(card.getSum()));
        }
        System.out.println("\nСумма всех карт и кошельков = " + (sumCard + sumWalet));
    }

}
