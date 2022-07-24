package com.company;

class Money {
    private String name;  //Название
    private String sum;      //сумма

    public Money(String name, String sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Money{" +
                "Имя =' " + name + '\'' +
                ", Сумма = " + sum +
                '}' + "\n";
    }
}
