package ru.otus.homework.classes;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;

public class Atm {

    private HashMap<Denomination, ? extends Cell> cells;
    public Atm(BankNote[] bankNotes){
        //todo распихать банкноты по ячейкам
    }

    public BankNote[] GetBanknotes(int sum) throws ExecutionControl.NotImplementedException {
        //todo сумму оптимальным кол-вом банкнот
        throw new ExecutionControl.NotImplementedException("JOPA");
    }
}
