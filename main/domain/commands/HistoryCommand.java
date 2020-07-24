package domain.commands;

import domain.entities.Wallet;
import domain.interfaces.Command;

import java.util.Deque;

public class HistoryCommand implements Command<HistoryCommand.Input> {

    private Input input;
    private Wallet wallet;
    private HistorySavingConvertCommand historySavingConvertCommand;

    public HistoryCommand(Input input, Wallet wallet, HistorySavingConvertCommand historySavingConvertCommand){
        this.input = input;
        this.wallet = wallet;
        this.historySavingConvertCommand = historySavingConvertCommand;
    }

    @Override
    public void execute() {
        Deque<String> transactionHistory = historySavingConvertCommand.getTransactions();

        if(transactionHistory.size() == 0){
            throw new IllegalArgumentException("There is no transactions yet.");
        }

        transactionHistory
                .stream()
                .limit(input.getNumberToShow())
                .forEach(System.out::println);
    }

    public static class Input extends EmptyInput {

        private final int numberToShow;

        public Input(int numberToShow) {
            if(numberToShow < 1) {
                throw new IllegalArgumentException("Input should be a positive number");
            }
            this.numberToShow = numberToShow;
        }

        public int getNumberToShow() {
            return numberToShow;
        }
    }
}
