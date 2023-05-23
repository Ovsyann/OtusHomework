package ru.otus.homework.classes;

import java.util.ArrayList;

public class Atm {

    private final Cell[] cells = new Cell[]{
            new Cell(Denomination.ONE_THOUSAND),
            new Cell(Denomination.FIVE_HUNDRED),
            new Cell(Denomination.TWO_HUNDRED),
            new Cell(Denomination.ONE_HUNDRED)
    };

    public BankNote[] getBanknotes(int sum){

        if(sum % Denomination.ONE_HUNDRED.getValue() != 0){
            throw new RuntimeException("too small sum: " + sum);
        }

        NeededSum neededSum = new NeededSum(sum);

        int thousandsAmount = getBankNotesAmount(neededSum, Denomination.ONE_THOUSAND);
        int fiveHundredsAmount = getBankNotesAmount(neededSum, Denomination.FIVE_HUNDRED);
        int twoHundredsAmount = getBankNotesAmount(neededSum, Denomination.TWO_HUNDRED);
        int oneHundredsAmount = getBankNotesAmount(neededSum, Denomination.ONE_HUNDRED);

        return getBanknotesFromCells(thousandsAmount, fiveHundredsAmount,
                twoHundredsAmount, oneHundredsAmount);
    }

    private int getBankNotesAmount(NeededSum sum, Denomination denomination){

        int counter = 0;
        while(sum.getValue() / denomination.getValue() > 0) {
            counter++;
            sum.Decrease(denomination.getValue());
        }

        return counter;
    }

    private BankNote[] getBanknotesFromCells(int thousandsAmount, int fiveHundredsAmount,
                                             int twoHundredsAmount, int oneHundredsAmount) {

        ArrayList<BankNote> bankNotes = new ArrayList<>();
        for (int i = 0; i < thousandsAmount; i++){
            bankNotes.add(cells[0].getBankNote());
        }
        for (int i = 0; i < fiveHundredsAmount; i++){
            bankNotes.add(cells[1].getBankNote());
        }
        for (int i = 0; i < twoHundredsAmount; i++){
            bankNotes.add(cells[2].getBankNote());
        }
        for (int i = 0; i < oneHundredsAmount; i++){
            bankNotes.add(cells[3].getBankNote());
        }

        BankNote[] bankNotesOut = bankNotes.toArray(new BankNote[0]);
        printBankNotesInfo(bankNotesOut);
        printCellsReminder();
        return bankNotesOut;
    }

    private void printCellsReminder() {

        System.out.println("\nReminder");
        for (Cell cell:
             cells) {
            System.out.println(cell.getDenomination() + ": " + cell.getCount());
        }
    }

    private void printBankNotesInfo(BankNote[] bankNotes) {
        Denomination denomination = bankNotes[0].getDenomination();
        int counter = 1;
        System.out.println("Issued");
        for(int i = 1; i < bankNotes.length; i++){
            if(bankNotes[i].getDenomination() == denomination){
                counter++;
            }
            else {
                System.out.println(denomination + ": " + counter);
                counter = 1;
                denomination = bankNotes[i].getDenomination();
            }
        }

        System.out.println(denomination + ": " + counter);
    }

    public void putBanknotes(BankNote[] bankNotes){

        for (BankNote bankNote:
                bankNotes) {
            for (var cell:
                    cells) {
                if(cell.getDenomination().getValue() == bankNote.getValue()){
                    cell.putBankNote(bankNote);
                }
            }
        }
    }
}
