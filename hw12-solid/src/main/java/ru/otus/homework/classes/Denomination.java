package ru.otus.homework.classes;

public enum Denomination {
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000);

    private final int value;

    Denomination(final int value){

        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
