package ru.otus.homework;

import ru.otus.homework.classes.Atm;
import ru.otus.homework.classes.BankNote;
import ru.otus.homework.classes.Denomination;

public class Main {
    public static void main(String[] args){

        Atm atm = new Atm();
        atm.putBanknotes(new BankNote[]{
                new BankNote(Denomination.ONE_THOUSAND),
                new BankNote(Denomination.ONE_THOUSAND),
                new BankNote(Denomination.FIVE_HUNDRED),
                new BankNote(Denomination.FIVE_HUNDRED),
                new BankNote(Denomination.TWO_HUNDRED),
                new BankNote(Denomination.TWO_HUNDRED),
                new BankNote(Denomination.ONE_HUNDRED),
                new BankNote(Denomination.ONE_HUNDRED)
        });

        BankNote[] bankNotes = atm.getBanknotes(1900);
    }
}
