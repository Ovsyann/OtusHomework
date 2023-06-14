package ru.otus.homework.classes;

import java.util.ArrayList;

public class SimpleAtm implements Atm{

    private final Cell[] cells;

    public SimpleAtm(Cell[] cells){

        this.cells = cells.clone();
    }
    @Override
    public BankNote[] getBanknotes(int sum){

        NeededSum neededSum = new NeededSum(sum);
        if(cantGet(neededSum)){

            throw new RuntimeException("Can not get: " + sum);
        }

        int thousandsAmount = getBankNotesAmount(neededSum, Denomination.ONE_THOUSAND);
        int fiveHundredsAmount = getBankNotesAmount(neededSum, Denomination.FIVE_HUNDRED);
        int twoHundredsAmount = getBankNotesAmount(neededSum, Denomination.TWO_HUNDRED);
        int oneHundredsAmount = getBankNotesAmount(neededSum, Denomination.ONE_HUNDRED);

        return getBanknotesFromCells(thousandsAmount, fiveHundredsAmount,
                twoHundredsAmount, oneHundredsAmount);
    }

    private static boolean cantGet(NeededSum sum) {
        return sum.getValue() % Denomination.ONE_HUNDRED.getValue() != 0;
    }

    @Override
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

    @Override
    public void showState() {

        System.out.println("\nState:");
        for (Cell cell:
                cells) {
            System.out.println(cell.getDenomination() + ": " + cell.getCount());
        }
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
        showState();
        return bankNotesOut;
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

}
