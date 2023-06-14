package ru.otus.homework.classes;

public interface Atm {

    BankNote[] getBanknotes(int sum);
    void putBanknotes(BankNote[] bankNotes);

    void showState();
}
