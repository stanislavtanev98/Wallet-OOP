package domain.commands;

import domain.entities.Wallet;
import domain.interfaces.Command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseCommand implements Command<ExpenseCommand.Input> {

    private Input input;
    private Wallet wallet;
    private HistorySavingConvertCommand historySavingConvertCommand;

    public ExpenseCommand(Input input, Wallet wallet, HistorySavingConvertCommand historySavingConvertCommand){
        this.input = input;
        this.wallet = wallet;
        this.historySavingConvertCommand = historySavingConvertCommand;
    }

    @Override
    public void execute() {
        expenseMoney(input, wallet);
    }

    private void expenseMoney(Input input, Wallet wallet) {
        BigDecimal amount = wallet.getTotalAmount();
        BigDecimal subtractedMoney = amount.subtract(input.money);
        if(subtractedMoney.doubleValue() < 0) {
            throw new IllegalStateException("You don't have enough money! You need " + Math.abs(subtractedMoney.doubleValue()) + " euro more to make this transaction.");
        }
        wallet.setTotalAmount(amount.subtract(input.money));
        wallet.setTotalSpentMoney(wallet.getTotalSpentMoney().add(input.money));
        historySavingConvertCommand.saveTransaction(input.toString());
        System.out.println(input.toString());
    }

    public static class Input extends EmptyInput {

        private BigDecimal money;
        private String type;
        private LocalDateTime time;

        public Input(String type, BigDecimal money){
            this.setMoney(money);
            this.type = type;
            this.time = LocalDateTime.now();
        }

        public void setMoney(BigDecimal money) {
            if(money.doubleValue() < 0) {
                throw new IllegalStateException("You don't have enough money! You need " +
                        Math.abs(money.doubleValue()) +
                        " euro more to make this transaction.");
            }
            this.money = money;
        }

        @Override
        public String toString() {
            return String.format("You expense %.2f euro for %s at %tF %tT",
                    money,
                    type,
                    time,
                    time);
        }
    }

}
