package ru.otus.homework.classes;

public class NeededSum {
    private int sum;

    public NeededSum(int sum) {
        this.sum = sum;
    }

    public void Decrease(int value){
        sum -= value;
    }

    public int getValue() {
        return sum;
    }
}
