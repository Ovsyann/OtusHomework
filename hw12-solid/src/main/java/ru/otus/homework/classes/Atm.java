package ru.otus.homework.classes;

import jdk.jshell.spi.ExecutionControl;

public class Atm {

    private Cell[] cells = new Cell[]{
            new Cell(Denomination.ONE_HUNDRED),
            new Cell(Denomination.TWO_HUNDRED),
            new Cell(Denomination.FIVE_HUNDRED),
            new Cell(Denomination.ONE_THOUSAND)
    };

    public BankNote[] getBanknotes(int sum) throws ExecutionControl.NotImplementedException {
        //todo сумму оптимальным кол-вом банкнот
        throw new ExecutionControl.NotImplementedException("JOPA");
    }

    public void putBanknotes(BankNote[] bankNotes) throws ExecutionControl.NotImplementedException {
        //todo распихать банкноты по ячейкам
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
