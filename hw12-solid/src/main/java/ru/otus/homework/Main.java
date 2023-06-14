package ru.otus.homework;

import ru.otus.homework.classes.*;

public class Main {
    public static void main(String[] args){

        Cell[] cells = new Cell[]{
                new Cell(Denomination.ONE_THOUSAND),
                new Cell(Denomination.FIVE_HUNDRED),
                new Cell(Denomination.TWO_HUNDRED),
                new Cell(Denomination.ONE_HUNDRED)
        };

        Atm simpleAtm = new SimpleAtm(cells);
        simpleAtm.putBanknotes(new BankNote[]{
                new BankNote(Denomination.ONE_THOUSAND),
                new BankNote(Denomination.ONE_THOUSAND),
                new BankNote(Denomination.FIVE_HUNDRED),
                new BankNote(Denomination.FIVE_HUNDRED),
                new BankNote(Denomination.TWO_HUNDRED),
                new BankNote(Denomination.TWO_HUNDRED),
                new BankNote(Denomination.ONE_HUNDRED),
                new BankNote(Denomination.ONE_HUNDRED)
        });

        BankNote[] bankNotes = simpleAtm.getBanknotes(1900);
    }
}
