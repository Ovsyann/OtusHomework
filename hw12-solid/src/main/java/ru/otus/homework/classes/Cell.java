package ru.otus.homework.classes;

import java.util.Stack;

public class Cell {

    private final Stack<BankNote> bankNotes = new Stack<>();
    private final Denomination denomination;

    public Cell(Denomination denomination){

        this.denomination = denomination;
    }

    public void putBankNote(BankNote bankNote){
        bankNotes.push(bankNote);
    }

    public BankNote getBankNote(){
        return bankNotes.pop();
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
