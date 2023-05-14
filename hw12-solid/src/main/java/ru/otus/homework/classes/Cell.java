package ru.otus.homework.classes;

import java.util.Stack;

public class Cell {

    private Stack<BankNote> bankNotes = new Stack<>();
    private Denomination denomination;

    public Cell(Denomination denomination){

        this.denomination = denomination;
    }

    public void setBankNote(BankNote bankNote){
        bankNotes.push(bankNote);
    }

    public BankNote getBankNote(){
        return bankNotes.pop();
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
