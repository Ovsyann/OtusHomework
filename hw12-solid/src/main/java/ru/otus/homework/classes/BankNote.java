package ru.otus.homework.classes;

public class BankNote {
    private final Denomination denomination;

    public BankNote(Denomination denomination) {
        this.denomination = denomination;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public int getValue(){
        return denomination.getValue();
    }
}
