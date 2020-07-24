package domain.commands;

import domain.entities.Wallet;
import domain.interfaces.Command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeCommand implements Command<IncomeCommand.Input> {

    private Input input;
    private Wallet wallet;
    private HistorySavingConvertCommand historySavingConvertCommand;

    public IncomeCommand(Input input, Wallet wallet, HistorySavingConvertCommand historySavingConvertCommand){
        this.input = input;
        this.wallet = wallet;
        this.historySavingConvertCommand = historySavingConvertCommand;
    }

    @Override
    public void execute() {
        addMoney(input, wallet);
    }

    private void addMoney(Input input, Wallet wallet) {
        BigDecimal amount = wallet.getTotalAmount();
        wallet.setTotalAmount(amount.add(input.money));
        wallet.setTotalIncomeMoney(wallet.getTotalIncomeMoney().add(input.money));
        historySavingConvertCommand.saveTransaction(input.toString());
        System.out.println(input.toString());
    }

    public static class Input extends EmptyInput {

        private BigDecimal money;
        private LocalDateTime time;

        public Input(BigDecimal money){
            this.setMoney(money);
            this.time = LocalDateTime.now();
        }

        public void setMoney(BigDecimal money) {
            if(money.doubleValue() < 0) {
                throw new IllegalStateException("You cannot add negative amount. " +
                        "\n If you want to remove money from your account write Expense.");
            } else if (money.doubleValue() < 1.0) {
                throw new IllegalStateException("You should add the minimum sum of 1 euro to make the Income successful");
            }
            this.money = money;
        }

        @Override
        public String toString() {
            return String.format("You add %.2f euro at %tF %tT",
                    money,
                    time,
                    time);
        }
    }
}
