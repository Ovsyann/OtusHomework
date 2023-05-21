package ru.otus.homework.classes;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Arrays;

public class Atm {

    private Cell[] cells = new Cell[]{
            new Cell(Denomination.ONE_THOUSAND),
            new Cell(Denomination.FIVE_HUNDRED),
            new Cell(Denomination.TWO_HUNDRED),
            new Cell(Denomination.ONE_HUNDRED)
    };

    public BankNote[] getBanknotes(int sum){
        //todo сумму оптимальным кол-вом банкнот
        if(sum % Denomination.ONE_HUNDRED.getValue() != 0){
            throw new RuntimeException("too small sum: " + sum);
        }

        int thousandsAmount = 0;
        int fiveHundredsAmount = 0;
        int twoHundredsAmount = 0;
        int oneHundredsAmount = 0;

        while(sum / 1000 > 0) {
            thousandsAmount++;
            sum -= 1000;
        }
        while(sum / 500 > 0) {
            fiveHundredsAmount++;
            sum -= 500;
        }
        while(sum / 200 > 0) {
            twoHundredsAmount++;
            sum -= 200;
        }
        while(sum / 100 > 0) {
            oneHundredsAmount++;
            sum -= 100;
        }

        return getBanknotesFromCells(thousandsAmount, fiveHundredsAmount,
                twoHundredsAmount, oneHundredsAmount);
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

        return bankNotes.toArray(new BankNote[bankNotes.size()]);
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
